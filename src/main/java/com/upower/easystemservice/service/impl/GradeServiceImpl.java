package com.upower.easystemservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.upower.easystemservice.mapper.GradeMapper;
import com.upower.easystemservice.mapper.UserInfoMapper;
import com.upower.easystemservice.pojo.Grade;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GradeServiceImpl implements GradeService {
    private final String ADMIN="[admin]";
    private final String TEACHER="[teacher]";
    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * 添加成绩
     * @param grade
     * @return
     */
    @Override
    public String insertGrade(Grade grade) {
        int i = gradeMapper.insertGrade(grade);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    /**
     * 修改成疾
     * @param grade
     * @return
     */
    @Override
    public String updateGrade(Grade grade) {
        int i = gradeMapper.updateGrade(grade);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    /**
     * 查询成绩
     * @param title
     * @param token
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean searchGrade(String title, String token, Integer page, Integer limit) {
        Page<Grade> pages;

        //根据token判断用户角色
        String access = userInfoMapper.getAccessBytoken(token);

        Integer id = userInfoMapper.getTeacher(token).getUser_id();

        PageHelper.startPage(page, limit);//开启分页
        if(ADMIN.equals(access)){
            if (StringUtils.isEmpty(title)){
                //管理员
                pages = (Page<Grade>) gradeMapper.searchGradeAdmin("");
            }else {
                pages = (Page<Grade>) gradeMapper.searchGradeAdmin(title);
            }

        }else if(TEACHER.equals(access)){
            //老师
            if(StringUtils.isEmpty(title)){
                pages = (Page<Grade>)gradeMapper.searchGradeTeacher(id,"");
            }else {
                pages = (Page<Grade>)gradeMapper.searchGradeTeacher(id,title);
            }

        }else {
            //学生
            if(StringUtils.isEmpty(title)){
                pages = (Page<Grade>)gradeMapper.searchGradeStudent(id,"");
            }else {
                pages = (Page<Grade>)gradeMapper.searchGradeStudent(id,title);
            }
        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }
}

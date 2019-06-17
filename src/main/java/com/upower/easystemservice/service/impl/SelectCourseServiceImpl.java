package com.upower.easystemservice.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.upower.easystemservice.mapper.SelectCourseMapper;
import com.upower.easystemservice.mapper.UserInfoMapper;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.SelectCourse;
import com.upower.easystemservice.service.SelectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SelectCourseServiceImpl implements SelectCourseService {
    @Autowired
    private SelectCourseMapper selectCourseMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    private final String ADMIN="[admin]";
    private final String TEACHER="[teacher]";

    @Override
    public String insertSelectCourse(SelectCourse course) {
        Integer stuid =selectCourseMapper.selectidByname(course.getName());
        course.setStuid(stuid);
        int i = selectCourseMapper.insertStuCourse(course);
        if (i > 0) {
            return "选课成功";
        } else {
            return "选课失败";
        }
    }

    @Override
    public PageBean searchSelectionInfo(String title, String token, Integer page, Integer limit) {

        Page<SelectCourse> pages;

        //根据token判断用户角色
        String access = userInfoMapper.getAccessBytoken(token);
        Integer id = userInfoMapper.getTeacher(token).getUser_id();
        PageHelper.startPage(page, limit);//开启分页
        if(ADMIN.equals(access)){
            if (StringUtils.isEmpty(title)){
                //管理员
                pages = (Page<SelectCourse>) selectCourseMapper.searchAdminCourse("");
            }else {
                pages = (Page<SelectCourse>) selectCourseMapper.searchAdminCourse(title);
            }

        }else {
            //老师
            if(StringUtils.isEmpty(title)){
                pages = (Page<SelectCourse>)selectCourseMapper.searchTeacherCourse(id,"");
            }else {
                pages = (Page<SelectCourse>)selectCourseMapper.searchTeacherCourse(id,title);
            }

        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }


     //课表
    @Override
    public PageBean searchSchedule(String title, String token, Integer page, Integer limit) {


        Page<SelectCourse> pages;

        //根据token判断用户角色
        String access = userInfoMapper.getAccessBytoken(token);

        Integer id = userInfoMapper.getTeacher(token).getUser_id();

        PageHelper.startPage(page, limit);//开启分页
        if(ADMIN.equals(access)){
            if (StringUtils.isEmpty(title)){
                //管理员
                pages = (Page<SelectCourse>) selectCourseMapper.searchAdminCourse("");
            }else {
                pages = (Page<SelectCourse>) selectCourseMapper.searchAdminCourse(title);
            }

        }else if(TEACHER.equals(access)){
            //老师
            if(StringUtils.isEmpty(title)){
                pages = (Page<SelectCourse>)selectCourseMapper.searchTeacherCourse(id,"");
            }else {
                pages = (Page<SelectCourse>)selectCourseMapper.searchTeacherCourse(id,title);
            }

        }else {
            //学生
            if(StringUtils.isEmpty(title)){
                pages = (Page<SelectCourse>)selectCourseMapper.searchStudentCourse(id,"");
            }else {
                pages = (Page<SelectCourse>)selectCourseMapper.searchStudentCourse(id,title);
            }
        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }

}

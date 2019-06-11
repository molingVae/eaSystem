package com.upower.easystemservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.upower.easystemservice.mapper.TeacherMapper;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.Teacher;
import com.upower.easystemservice.pojo.User;
import com.upower.easystemservice.service.TeacherService;
import com.upower.easystemservice.util.StringRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 添加
     * @param teacher
     * @return
     */
    @Override
    public String insertTeacher(Teacher teacher) {
        List<User> users = teacherMapper.selectUserAll();
        for (User user : users) {
            if (user.getName().equals(teacher.getName())) {
                return "姓名不能重复";
            }
        }
        String[] acc = {"teacher"};
        teacher.setToken(StringRandom.getStringRandom(15));
        teacher.setAccess(Arrays.toString(acc));
        teacher.setAvator("https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png");
        teacher.setRoles("1");
        int i = teacherMapper.insertTeacher(teacher);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    /**
     * 模糊查询老师
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean searchTeacher(String name, Integer page, Integer limit) {
        Page<Teacher> pages;
        PageHelper.startPage(page, limit);//开启分页
        //若不查询
        if (StringUtils.isEmpty(name)) {
            pages = (Page<Teacher>) teacherMapper.searchTeacher("", "1");
        } else {
            pages = (Page<Teacher>) teacherMapper.searchTeacher(name, "1");
        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public String deleteTeacher(int id) {
        int i = teacherMapper.deleteTeacher(id);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    /**
     * 修改
     * @param teacher
     * @return
     */
    @Override
    public String updateTeacher(Teacher teacher) {
        int i = teacherMapper.updateTeacher(teacher);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
}

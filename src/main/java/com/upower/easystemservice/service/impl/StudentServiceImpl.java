package com.upower.easystemservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.upower.easystemservice.mapper.StudentMapper;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.Student;
import com.upower.easystemservice.pojo.User;
import com.upower.easystemservice.service.StudentService;
import com.upower.easystemservice.util.StringRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public String insertStudent(Student student) {
        List<User> users = studentMapper.selectUserAll();
        for (User user : users) {
            if (user.getName().equals(student.getName())) {
                return "姓名不能重复";
            }
        }
        String[] acc = {"student"};
        student.setToken(StringRandom.getStringRandom(15));
        student.setAccess(Arrays.toString(acc));
        student.setAvator("https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png");
        student.setRoles("2");
        int i = studentMapper.insertStudent(student);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @Override
    public PageBean searchStudent(String name, Integer page, Integer limit) {
        Page<Student> pages;
        PageHelper.startPage(page, limit);//开启分页
        //若不查询
        if (StringUtils.isEmpty(name)) {
            pages = (Page<Student>) studentMapper.searchStudent("", "2");
        } else {
            pages = (Page<Student>) studentMapper.searchStudent(name, "2");
        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }

    @Override
    public String deleteStudent(int user_id) {
        int i = studentMapper.deleteStudent(user_id);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public String updateStudent(Student student) {
        int i = studentMapper.updateStudent(student);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
}

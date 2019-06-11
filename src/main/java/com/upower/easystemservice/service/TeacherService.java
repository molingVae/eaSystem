package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.Teacher;

public interface TeacherService {
    String insertTeacher(Teacher teacher);

    PageBean searchTeacher(String name, Integer page, Integer limit);

    String deleteTeacher(int id);

    String updateTeacher(Teacher teacher);
}

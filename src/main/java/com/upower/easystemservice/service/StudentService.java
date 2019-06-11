package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.Student;

public interface StudentService {
    String insertStudent(Student student);

    PageBean searchStudent(String name, Integer page, Integer limit);

    String deleteStudent(int id);

    String updateStudent(Student student);
}

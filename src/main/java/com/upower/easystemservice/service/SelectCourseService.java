package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.SelectCourse;

public interface SelectCourseService {

    String insertSelectCourse(SelectCourse course);

    PageBean searchSelectionInfo(String title, String name, Integer page, Integer limit);
}

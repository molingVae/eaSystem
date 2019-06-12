package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.Course;
import com.upower.easystemservice.pojo.PageBean;

public interface CouresService {
    String insertCoures(Course course);

    PageBean searchCoures(String coursename, Integer page, Integer limit);

    String deleteCoures(int courseid);

    String updateCoures(Course course);
}

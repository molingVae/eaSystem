package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.Grade;
import com.upower.easystemservice.pojo.PageBean;

public interface GradeService {
    String insertGrade(Grade grade);

    String updateGrade(Grade grade);

    PageBean searchGrade(String title, String token, Integer page, Integer limit);
}

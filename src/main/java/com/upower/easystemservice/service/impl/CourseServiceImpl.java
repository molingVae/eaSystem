package com.upower.easystemservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.upower.easystemservice.mapper.CourseMapper;
import com.upower.easystemservice.pojo.Course;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.CouresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CourseServiceImpl implements CouresService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public String insertCoures(Course course) {
        int i = courseMapper.insertCourse(course);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @Override
    public PageBean searchCoures(String coursename, Integer page, Integer limit) {
        Page<Course> pages;
        PageHelper.startPage(page, limit);//开启分页
        //若不查询
        if (StringUtils.isEmpty(coursename)) {
            pages = (Page<Course>) courseMapper.searchCourse("");
        } else {
            pages = (Page<Course>) courseMapper.searchCourse(coursename);
        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }

    @Override
    public String deleteCoures(int courseid) {
        int i = courseMapper.deleteCourse(courseid);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public String updateCoures(Course course) {
        int i = courseMapper.updateCourse(course);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }
}

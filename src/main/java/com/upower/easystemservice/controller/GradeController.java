package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.Grade;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.impl.GradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GradeController {
    @Autowired
    private GradeServiceImpl gradeService;

    /**
     * 添加成绩(老师)
     * @param grade
     * @return
     */
    @PostMapping("/insertGrade")
    public String insertGrade(Grade grade){
        return gradeService.insertGrade(grade);
    }

    /**
     * 修改成绩（老师）
     * @param grade
     * @param name
     * @return
     */
    @PostMapping("/updateGrade")
    public String updateGrade(Integer grade, String name){
        return gradeService.updateGrade(grade,name);
    }

    /**
     * 查询成绩
     * @param title
     * @param token
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/searchGrade")
    public PageBean searchGrade(String title, String token, Integer page, Integer limit){
        return gradeService.searchGrade(title,token,page, limit);

    }
}

package com.upower.easystemservice.pojo;

import lombok.Data;

@Data
public class Grade {
    private Integer gradeid;//成绩id
    private Integer stuid;//学号
    private String stuname;//学生姓名
    private String coursename;//课程名称
    private String credit;//学分
    private Integer grade;//成绩
    private String teacherid;//教师id
}

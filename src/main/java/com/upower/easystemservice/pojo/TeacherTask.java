package com.upower.easystemservice.pojo;

import lombok.Data;

@Data
public class TeacherTask {
    private String taskid;
    private String taskcourname;//课程名称
    private String taskyear; //学年
    private String taskteam;//学期
    private String taskway;//考试方式
    private String taskdepart;//开设院系
}

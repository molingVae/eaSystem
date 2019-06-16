package com.upower.easystemservice.pojo;

import lombok.Data;

@Data
public class AdminTask {
    private Integer taskid;//教学ID
    private String taskcourname;//课程名称
    private Integer taskteaid;//老师ID
    private String taskyear; //学年
    private String taskteam;//学期
    private String taskway;//考试方式
    private String taskdepart;//开设院系
    private String classdate;//教学时间
    private String classplace;//教学地点
}

package com.upower.easystemservice.pojo;

import lombok.Data;

@Data
public class SelectCourse {
    private Integer selectid;
    private String name;
    private Integer stuid;
    private Integer teacherid;
    private String courname;
    private String taskyear;
    private String taskteam;
    private String taskway;
    private String taskdepart;
    private String classdate;
    private String classplace;
}

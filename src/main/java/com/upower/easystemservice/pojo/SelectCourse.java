package com.upower.easystemservice.pojo;

import lombok.Data;

@Data
public class SelectCourse {
    private Integer selectid;
    private Integer stuid;
    private String courname;
    private String depart;
    private Integer teacherid;
}

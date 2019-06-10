package com.upower.easystemservice.pojo;


import lombok.Data;


@Data
public class User {
    private Integer user_id;
    private String password;
    private String name;
    private String access;
    private String token;
    private String avator;
    private String roles;//角色权限
}

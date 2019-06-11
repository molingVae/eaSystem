package com.upower.easystemservice.pojo;

import lombok.Data;

@Data
public class Admin extends User {
    private String sex;//性别：0是女，1是男
    private String idcard;//身份证
    private String birthday;//生日
    private String departname;//部门
    private String position;//职位
    private String tel;//联系方式
    private String address;//地址
}

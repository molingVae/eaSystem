package com.upower.easystemservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Admin extends User {
    private String sex;//性别
    private String idcard;//身份证

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;//生日

    private String departname;//部门
    private String position;//职位
    private String tel;//联系方式
    private String address;//地址
}

package com.upower.easystemservice.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Student extends User {
    private String sex;//性别：0是女，1是男
    private String idcard;//身份证
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;//生日
    private String departname;//院系
    private String majorname;//专业
    private String degree;//层次
    private String tel;//联系方式
    private String address;//地址
}

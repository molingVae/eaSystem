package com.upower.easystemservice.pojo;

import lombok.Data;

@Data
public class Teacher extends User {
    private String sex;//性别：0是女，1是男
    private String idcard;//身份证
    private String birthday;//生日
    private String departname;//院系
    private String majorname;//专业
    private String degree;//毕业学历
    private String position;//职位
    private String tel;//联系方式
    private String address;//地址
}

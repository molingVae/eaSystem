package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {
    @Insert("insert into user(name,password,sex,idcard,birthday,departname,position,tel,address) " +
            "values(#{name},#{password},#{sex},#{idcard},#{birthday},#{departname},#{position},#{tel},#{address}) ")
    void insertAdamin(Admin admin);
}

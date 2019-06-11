package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminMapper {
    //查询所有用户
    @Select("select * from user")
    List<Admin> getAllAdmin();
    //添加用户
    @Insert("insert into user(name,password,sex,idcard,birthday,departname,position,tel,address) " +
            "values(#{name},#{password},#{sex},#{idcard},#{birthday},#{departname},#{position},#{tel},#{address}) ")
    void insertAdamin(Admin admin);
}

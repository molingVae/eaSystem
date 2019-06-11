package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper extends tk.mybatis.mapper.common.Mapper<User> {

    @Select("select * from user where name=#{name}")
    public User selectUserByname(String name);

    @Select("select * from user where token=#{token}")
    public User selectUserBytoken(String token);
}

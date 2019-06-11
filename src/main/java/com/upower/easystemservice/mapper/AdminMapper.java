package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdminMapper extends Mapper<Admin> {

    @Insert("insert into user(access,avator,token,roles,name,password,sex,idcard,birthday,departname,position,tel,address) " +
            "values(#{access},#{avator},#{token},#{roles},#{name},#{password},#{sex},#{idcard},#{birthday},#{departname},#{position},#{tel},#{address}) ")
    int insertAdamin(Admin admin);

    /**
     * 模糊查询
     * @param name 名称
     * @param roles 角色
     * @return
     */
    @Select("select * from user where name like '%${name}%' and roles=#{roles}")
    List<Admin> searchAdmin(@Param("name") String name,@Param("roles") String roles);
}



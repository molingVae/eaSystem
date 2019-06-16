package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.Admin;
import com.upower.easystemservice.pojo.Student;
import com.upower.easystemservice.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * description:
 * author: 沫凌
 * create: 2019-06-16 16:10
 */
@Mapper
public interface UserInfoMapper {


    @Select("select access from user where token=#{token}")
    String getAccessBytoken(String token);

    @Select("select * from user where token=#{token}")
    Admin getAdmin(String token);

    @Select("select * from user where token=#{token}")
    Student getStudent(String token);

    @Select("select * from user where token=#{token}")
    Teacher getTeacher(String token);

    @Select("select password from user where name=#{name}")
    String getPassByName(String name);

    @Update("update user set password=#{newpassword} where name=#{name}")
    int upPass(@Param("name") String name, @Param("newpassword") String newpassword);
}

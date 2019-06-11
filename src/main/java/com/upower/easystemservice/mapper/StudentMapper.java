package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.Student;
import com.upower.easystemservice.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface StudentMapper {
    /**
     * 添加
     * @param student
     * @return
     */
    @Insert("insert into user(access,avator,token,roles,name,password,sex,idcard,departname,majorname,birthday,degree,tel,address) " +
            "values(#{access},#{avator},#{token},#{roles},#{name},#{password},#{sex},#{idcard},#{departname},#{majorname},#{birthday},#{degree},#{tel},#{address}) ")
    int insertStudent(Student student);
    /**
     * 模糊查询
     * @param name 名称
     * @param roles 角色
     * @return
     */
    @Select("select * from user where name like '%${name}%' and roles=#{roles}")
    List<Student> searchStudent(@Param("name") String name, @Param("roles") String roles);

    @Update("update user set password = #{password},idcard=#{idcard},birthday=#{birthday},sex=#{sex},departname=#{departname},majorname=#{majorname}," +
            "degree=#{degree},tel=#{tel},address=#{address} WHERE name = #{name}")
    int updateStudent(Student student);

    @Delete("delete from user where user_id=#{user_id}")
    int deleteStudent(@Param("user_id")Integer user_id);


    @Select("select * from user")
    List<User> selectUserAll();
}

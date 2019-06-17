package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.Grade;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface GradeMapper {
    //添加成绩
    @Insert("insert into grade(stuid,stuname,coursename,credit,grade,teacherid)" +
            "values(#{stuid},#{stuname},#{coursename},#{credit},#{grade},#{teacherid})")
    int insertGrade(Grade grade);
    //修改成绩
    @Update("update grade set stuid=#{stuid},stuname=#{stuname}," +
            "coursename=#{coursename},credit=#{credit},grade=#{grade},teacherid=#{teacherid} where gradeid=#{gradeid} ")
    int updateGrade(Grade grade);

    @Select("select user_id from user where name=#{name}")
    Integer selectidByname(String name);

    @Select("select * from grade where coursename like '%${coursename}%'")
    List<Grade> searchGradeAdmin(@Param("coursename") String title);

    @Select("select * from grade where teacherid=#{teacherid} and coursename like '%${coursename}%'")
    List<Grade> searchGradeTeacher(@Param("teacherid") Integer teacherid,@Param("coursename") String title);

    @Select("select * from grade where stuid=#{stuid} and coursename like '%${coursename}%'")
    List<Grade> searchGradeStudent(@Param("stuid") Integer stuid,@Param("coursename") String title);
}

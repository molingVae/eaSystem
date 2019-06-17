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
    @Update("update grade set grade=#{grade} where stuid=#{stuid} ")
    int updateGrade(@Param("grade") Integer grade, @Param("stuid") Integer stuid);

    @Select("select user_id from user where name=#{name}")
    Integer selectidByname(String name);

    @Select("select * from grade where courname like '%${courname}%' and teacherid=#{teacherid} and stuid=#{stuid}")
    List<Grade> searchGradeAdmin(@Param("courname") String title);

    @Select("select * from grade where teacherid=#{teacherid} and courname like '%${courname}%'")
    List<Grade> searchGradeTeacher(@Param("teacherid") Integer teacherid,@Param("courname") String title);

    @Select("select * from grade where stuid=#{stuid} and courname like '%${courname}%'")
    List<Grade> searchGradeStudent(@Param("stuid") Integer stuid,@Param("courname") String title);
}

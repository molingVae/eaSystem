package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.SelectCourse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SelectCourseMapper {
    //学生选课(学生)
    @Insert("insert into selectcourse(stuid,teacherid,courname,taskyear,taskteam,taskway,taskdepart,classdate,classplace) " +
            "values(#{stuid},#{teacherid},#{courname},#{taskyear},#{taskteam},#{taskway},#{taskdepart},#{classdate},#{classplace})")
    int insertStuCourse(SelectCourse stuCourse);
    @Select("select user_id from user where name=#{name}")
    Integer selectidByname(String name);

    //选课信息(管理员)
    @Select("select * from selectcourse where courname like '%${courname}%'")
    List<SelectCourse> searchAdminCourse(@Param("courname") String title);
    //选课信息（老师）
    @Select("select * from selectcourse where teacherid=#{teacherid} and courname like '%${courname}%'")
    List<SelectCourse> searchTeacherCourse(@Param("teacherid") Integer teacherid,@Param("courname") String title);
}

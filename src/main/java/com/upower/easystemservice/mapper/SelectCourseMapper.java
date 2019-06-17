package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.SelectCourse;
import com.upower.easystemservice.pojo.StuCourse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SelectCourseMapper {

    @Select("select * from selectcourse where stuid like '%${stuid}%' and roles=#{roles}")
    List<SelectCourse> searchSelectCourse(@Param("stuid") Integer stuid, @Param("roles") String roles);

    @Insert("insert into selectcourse(stuid,teacherid,courname,taskyear,taskteam,taskway,taskdepart,classdate,classplace) " +
            "values(#{stuid},#{teacherid},#{courname},#{taskyear},#{taskteam},#{taskway},#{taskdepart},#{classdate},#{classplace})")
    int insertStuCourse(StuCourse stuCourse);

    @Select("select user_id from user where name=#{name}")
    Integer selectStuidByname(String name);
}

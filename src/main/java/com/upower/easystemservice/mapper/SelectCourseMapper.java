package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.SelectCourse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SelectCourseMapper {

    @Select("select * from selectcourse where stuid like '%${stuid}%' and roles=#{roles}")
    List<SelectCourse> searchSelectCourse(@Param("stuid") Integer stuid, @Param("roles") String roles);

    @Insert("insert into selectcourse(stuid,courname,depart,teacherid) values(#{stuid},#{courname},#{depart},#{teacherid})")
    int insertSelectCourse(SelectCourse selectCourse);

    @Delete("delete from selectcourse where stuid=#{stuid} ")
    int deleteSelectCourse(Integer stuid);
}

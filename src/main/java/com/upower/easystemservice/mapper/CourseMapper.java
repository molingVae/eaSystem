package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Insert("insert into courseinfo(coursename,coursekind,coursetype,credit) " +
            "values(#{coursename},#{coursekind},#{coursetype},#{credit})")
    int insertCourse(Course course);

    @Select("select * from courseinfo where coursename like '%${coursename}%' ")
    List<Course> searchCourse(@Param("coursename") String coursename);

    @Update("update courseinfo set coursename=#{coursename},coursekind=#{coursekind}" +
            ",coursetype=#{coursetype},credit=#{credit} where coursename=#{coursename} ")
    int updateCourse(Course course);

    @Delete("delete from courseinfo where courseid=#{courseid}")
    int deleteCourse(@Param("courseid")Integer courseid);
}

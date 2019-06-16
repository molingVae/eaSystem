package com.upower.easystemservice.mapper;

import com.upower.easystemservice.pojo.AdminTask;
import com.upower.easystemservice.pojo.TeacherTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    //教学任务查询（管理员）
    @Select("select * from taskinfo where taskcourname like '%${taskcourname}%' ")
    List<AdminTask> serachAdminTask(@Param("taskcourname") String taskcourname);
    //教学任务添加（管理员）
    @Insert("insert into taskinfo(taskcourname,taskteaid,taskyear,taskteam,taskway,taskdepart,classdate,classplace) " +
            "values(#{taskcourname},#{taskteaid},#{taskyear},#{taskteam},#{taskway},#{taskdepart},#{classdate},#{classplace})")
    int insertAdminTask(AdminTask adminTask);
    //教学任务删除（管理员）
    @Delete("delete from taskinfo where taskid=#{taskid}")
    int deleteAdminTask(@Param("taskid")Integer taskid);
    //教学任务修改（管理员）
    @Update("update taskinfo set taskcourname=#{taskcourname},taskteaid=#{taskteaid},taskdepart=#{taskdepart}" +
            ",taskyear=#{taskyear},taskteam=#{taskteam},taskway-=#{taskway},,classdate=#{classdate},classplace=#{classplace} where taskid=#{taskid} ")
    int updateAdminTask(AdminTask adminTask);
    //教学任务查询（教师）
    @Select("select taskcourname,taskyear,taskteam,taskway,taskdepart from taskinfo where taskid=#{taskid}")
    List<TeacherTask> serachTeacherTask(@Param("taskid")Integer taskid);
}

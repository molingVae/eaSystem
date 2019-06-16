package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.AdminTask;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.TeacherTask;

import java.util.List;

public interface TaskService {

    PageBean serachAdminTask(String name,Integer page, Integer limit);

    String insertAdminTask(AdminTask adminTask);

    String deleteAdminTask(Integer taskid);

    String updateAdminTask(AdminTask adminTask);

    PageBean serachTeacherTask(Integer taskid,Integer page, Integer limit);
}

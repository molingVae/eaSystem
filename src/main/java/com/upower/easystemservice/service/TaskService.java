package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.AdminTask;
import com.upower.easystemservice.pojo.PageBean;

public interface TaskService {

    PageBean serachAdminTask(String name,Integer page, Integer limit);

    String insertAdminTask(AdminTask adminTask);

    String deleteAdminTask(Integer taskid);

    String updateAdminTask(AdminTask adminTask);

    PageBean serachTeacherTask(String name,Integer page, Integer limit);
}

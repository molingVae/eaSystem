package com.upower.easystemservice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.upower.easystemservice.mapper.TaskMapper;
import com.upower.easystemservice.pojo.AdminTask;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.pojo.TeacherTask;
import com.upower.easystemservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    /**
     * 教学任务查询（管理员）
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean serachAdminTask(String name,Integer page, Integer limit) {

        Page<AdminTask> pages;
        PageHelper.startPage(page, limit);//开启分页
        //若不查询
        if (StringUtils.isEmpty(name)) {
            pages = (Page<AdminTask>) taskMapper.serachAdminTask("");
        } else {
            pages = (Page<AdminTask>) taskMapper.serachAdminTask(name);
        }
        return new PageBean(pages.getTotal(), pages.getResult());
    }

    /**
     * 教学任务添加（管理员）
     * @param adminTask
     * @return
     */
    @Override
    public String insertAdminTask(AdminTask adminTask) {
        int i = taskMapper.insertAdminTask(adminTask);
        if (i > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    /**
     * 教学任务删除（管理员）
     * @param taskid
     * @return
     */
    @Override
    public String deleteAdminTask(Integer taskid) {
        int i = taskMapper.deleteAdminTask(taskid);
        if (i > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    /**
     * 教学任务修改（管理员）
     * @param adminTask
     * @return
     */
    @Override
    public String updateAdminTask(AdminTask adminTask) {
        int i = taskMapper.updateAdminTask(adminTask);
        if (i > 0) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @Override
    public PageBean serachTeacherTask(Integer taskid,Integer page, Integer limit) {
        Page<TeacherTask> pages;
        PageHelper.startPage(page,limit);//开启分页
        pages = (Page<TeacherTask>) taskMapper.serachTeacherTask(taskid);
        return new PageBean(pages.getTotal(), pages.getResult());
    }
}

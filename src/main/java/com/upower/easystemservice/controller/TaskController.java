package com.upower.easystemservice.controller;

import com.upower.easystemservice.pojo.AdminTask;
import com.upower.easystemservice.pojo.PageBean;
import com.upower.easystemservice.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;


    //添加教学任务（管理员）
    @PostMapping("/insertTask")
    public String insertAdminTask(AdminTask adminTask) {
        return taskService.insertAdminTask(adminTask);
    }

    //查询教学任务（管理员）
    @GetMapping("/searchTask")
    public PageBean searchAdminTask(String name, Integer page, Integer limit) {
        return taskService.serachAdminTask(name, page, limit);
    }

    //删除教学任务（管理员）
    @GetMapping("/deleteTask")
    public String deleteAdminTask(int id) {
        return taskService.deleteAdminTask(id);
    }

    //修改教学任务（管理员）
    @PostMapping("/updateTask")
    public String updateAdminTask(AdminTask adminTask) {
        return taskService.updateAdminTask(adminTask);
    }

    //查询教学任务（老师）
    @GetMapping("/searchTeacherTask")
    public PageBean searchCourse(String name,Integer page, Integer limit) {

        return taskService.serachTeacherTask(name, page, limit);
    }
}

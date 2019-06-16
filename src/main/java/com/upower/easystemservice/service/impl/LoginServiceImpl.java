package com.upower.easystemservice.service.impl;

import com.upower.easystemservice.mapper.LoginMapper;
import com.upower.easystemservice.pojo.User;
import com.upower.easystemservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * description:
 * author: 沫凌
 * create: 2019-06-11 8:49
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private HttpSession session;

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public String login(String userName, String password) {
        User user = loginMapper.selectUserByname(userName);
        if (user != null && user.getPassword().equals(password)) {
            return user.getToken();
        }
        return null;
    }

    @Override
    public User get_info(String token) {
        User user = loginMapper.selectUserBytoken(token);
        session.setAttribute("id", user.getUser_id());
        System.out.println(session.getAttribute("id"));
        return user;
    }

    public Integer getId() {
        System.out.println(session.getAttribute("id"));
        return (Integer) session.getAttribute("id");
    }
}

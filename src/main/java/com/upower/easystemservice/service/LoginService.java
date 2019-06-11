package com.upower.easystemservice.service;

import com.upower.easystemservice.pojo.User;

public interface LoginService {

      String login(String userName, String password);

      User get_info(String token) ;
}

package com.upower.easystemservice.service;

/**
 * description:
 * author: 沫凌
 * create: 2019-06-16 16:07
 */
public interface UserInfoService {


     Object  getUserInfo(String token);

     String upPass(String name, String oldPassword, String newpassword);
}

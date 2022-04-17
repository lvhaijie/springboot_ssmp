package com.lhj.service;


import com.lhj.pojo.User;

public interface LoginService {
    User login( String username, String password);
    User selectByName(String username);
}

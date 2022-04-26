package com.lhj.service;


import com.lhj.pojo.UserInfo;

public interface LoginService {
    UserInfo login( String username, String password);
    UserInfo selectByName( String username);

}

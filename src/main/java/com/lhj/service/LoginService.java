package com.lhj.service;


import com.lhj.pojo.SysUser;

public interface LoginService {
    SysUser login( String username, String password);
    SysUser selectByName( String username);

}

package com.lhj.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhj.pojo.UserInfo;

import java.util.List;

public interface LoginService extends IService<UserInfo> {
    UserInfo login( String username, String password);
    UserInfo selectByName( String username);
    IPage<UserInfo> getPage( Integer currentPage, Integer pageSize);
    //修改
    Boolean modify(UserInfo userInfo);
//    List<UserInfo> list();
}

package com.lhj.service.impl;

import com.lhj.dao.LoginDao;
import com.lhj.pojo.User;
import com.lhj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * mp快速开发，继承ServiceImpl<M,T>，再实现对应的接口
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public User login( String username, String password ) {
        return loginDao.user(username,password);
    }

    @Override
    public User selectByName( String username ) {
        return loginDao.selectByName(username);
    }
}

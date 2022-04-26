package com.lhj.service.impl;

import com.lhj.dao.LoginDao;
import com.lhj.pojo.SysUser;
import com.lhj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * mp快速开发，继承ServiceImpl<M,T>，再实现对应的接口
 */
//@Transactional

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public SysUser login( String username, String password ) {
        return loginDao.user(username,password);
    }

    @Override
    public SysUser selectByName( String username ) {
        return loginDao.selectByName(username);
    }


}

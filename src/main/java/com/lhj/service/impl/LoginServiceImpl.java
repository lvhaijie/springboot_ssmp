package com.lhj.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhj.dao.LoginDao;
import com.lhj.pojo.UserInfo;
import com.lhj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * mp快速开发，继承ServiceImpl<M,T>，再实现对应的接口
 */
@Transactional

@Service
public class LoginServiceImpl extends ServiceImpl<LoginDao,UserInfo> implements LoginService {
    @Autowired
    private LoginDao loginDao;


    @Override
    public UserInfo login( String username, String password ) {
        return loginDao.user(username,password);
    }

    @Override
    public UserInfo selectByName( String username ) {
        return loginDao.selectByName(username);
    }

    //修改
    @Override
    public Boolean modify( UserInfo userInfo ) {
        return loginDao.updateById(userInfo)>0;
    }



//    @Override
//    public List<UserInfo> list() {
//        return loginDao.selectAll();
//    }

    //分页查询
    @Override
    public IPage<UserInfo> getPage( Integer currentPage, Integer pageSize ) {
        IPage<UserInfo> page = new Page<>(currentPage, pageSize);
        loginDao.selectPage(page,null);
        return page;
    }




}

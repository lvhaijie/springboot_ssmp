package com.lhj.dao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginDaoTest {
    @Autowired
    private LoginDao userdao;

    @Test
    void login(){
        String username="zhangsan";
        String password="123";
        userdao.user(username,password);
    }
}

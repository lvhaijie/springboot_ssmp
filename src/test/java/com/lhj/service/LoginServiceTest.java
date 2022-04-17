package com.lhj.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    /**
     * 查询单个
     */
    @Test
    void login() {
        loginService.login("zhangsan","123");
    }


}

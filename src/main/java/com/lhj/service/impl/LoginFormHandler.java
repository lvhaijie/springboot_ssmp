package com.lhj.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhj.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Transactional

@Service
public class LoginFormHandler implements AuthenticationSuccessHandler,AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess( HttpServletRequest request, HttpServletResponse response, Authentication auth ) throws IOException, ServletException {
        Object principal = auth.getPrincipal();
        UserInfo userInfo=(UserInfo)principal;
        System.out.println("principal"+userInfo);
        PrintWriter writer=response.getWriter();
        writer.println(objectMapper.writeValueAsString(userInfo));
    }
}

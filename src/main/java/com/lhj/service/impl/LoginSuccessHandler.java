package com.lhj.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhj.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationSuccess( HttpServletRequest request, HttpServletResponse response, Authentication auth ) throws IOException, ServletException {
        Object principal = auth.getPrincipal();
        UserInfo userInfo=(UserInfo)principal;
        System.out.println("principal"+userInfo);
        PrintWriter writer=response.getWriter();
        writer.println(objectMapper.writeValueAsString(userInfo));
        writer.flush();
        writer.close();
    }
}

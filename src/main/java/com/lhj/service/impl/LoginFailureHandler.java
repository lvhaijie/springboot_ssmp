package com.lhj.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lhj.pojo.UserInfo;
import org.omg.CORBA.OMGVMCID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response, AuthenticationException exception ) throws IOException, ServletException {
//        if(exception instanceof BadCredentialsException){
//            response.getWriter().println(exception.getMessage());
//        }
        Map<String,Object> map=new HashMap<>();
//        map.put("code",0);
        map.put("msg","用户名或密码错误");
//        System.out.println(map.get("msg"));
//        response.getWriter().write(objectMapper.writeValueAsString(map));
        request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION",map.get("msg"));
//        System.out.println("错误信息"+request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString());
        request.getRequestDispatcher("/login/error").forward(request,response);
    }
}

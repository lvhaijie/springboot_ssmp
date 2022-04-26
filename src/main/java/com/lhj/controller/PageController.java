package com.lhj.controller;

import com.lhj.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PageController implements WebMvcConfigurer {
    @RequestMapping("/brand")
    public String brand(  ) {
        return "brand";
    }

    //用户首页
    @RequestMapping("/index")
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //未登录情况下
        if(principal=="anonymousUser"){
            return "index";
        }
        UserInfo userInfo = (UserInfo) principal;
        //已登录获取用户昵称
        model.addAttribute("name", userInfo.getUsername());
        return "index";
    }

    @RequestMapping("/login/error")
    public String loginerror( HttpServletRequest request, HttpServletResponse response, Model model){
        String exception =request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString();
//        System.out.println("错误信息是"+exception);
        model.addAttribute("error",exception);
        return "login";
    }

//    @Autowired
//    private LoginService loginService;
////        登录验证后台渲染
//    @RequestMapping("/login/error")
//    public ModelAndView logincheck( ModelAndView modelAndView, @Valid UserInfo userInfo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
//            modelAndView.setViewName("login");
//            return modelAndView;
//        }
//        String username = userInfo.getUsername();
//        String password = userInfo.getPassword();
//        UserInfo name = loginService.selectByName(username);
//        if(name==null){
//
//            modelAndView.addObject("error","该用户名不存在!");
//            modelAndView.setViewName("login");
//            return modelAndView;
//        }
//        UserInfo userInfo1 =loginService.login(username,password);
//        if(userInfo1 ==null){
//            modelAndView.addObject("error","密码错误!");
//            modelAndView.setViewName("login");
//            return modelAndView;
//        }
////        if("on".equals(remember)) {
////            Cookie cusername = new Cookie("cookie_username", username);
////            Cookie cpassword = new Cookie("cookie_password", password);
////            cusername.setMaxAge(60*60*24*7);
////            cpassword.setMaxAge(60*60*24*7);
////            response.addCookie(cusername);
////            response.addCookie(cpassword);
////        }
////        else {
////            Cookie[] cookies = request.getCookies();
////            if(cookies!=null){
////                for(Cookie cookie:cookies){
////                    if(cookie.getName().equals("cookie_username")||cookie.getName().equals("cookie_password")){
////                        cookie.setMaxAge(0);
////                        response.addCookie(cookie);
////                    }
////                }
////            }
////        }
//        modelAndView.addObject("username",username);
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }


    //跳转到登陆页面
    @GetMapping("/login")
    public String login(  ) {
        return "login";
    }
}



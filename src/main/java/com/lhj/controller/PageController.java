package com.lhj.controller;

import com.lhj.pojo.UserInfo;
import com.lhj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class PageController implements WebMvcConfigurer {
    @RequestMapping("/brand")
    public String brand(  ) {
        return "brand";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
        UserInfo userInfo = (UserInfo) principal;
        userInfo.getPassword();
        model.addAttribute("name", userInfo.getUsername());
        return "index";
    }

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ModelAndView logincheck( ModelAndView modelAndView, @Valid UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String username = userInfo.getUsername();
        String password = userInfo.getPassword();
        UserInfo name = loginService.selectByName(username);
        if(name==null){

            modelAndView.addObject("error","该用户名不存在!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        UserInfo userInfo1 =loginService.login(username,password);
        if(userInfo1 ==null){
            modelAndView.addObject("error","密码错误!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
//        if("on".equals(remember)) {
//            Cookie cusername = new Cookie("cookie_username", username);
//            Cookie cpassword = new Cookie("cookie_password", password);
//            cusername.setMaxAge(60*60*24*7);
//            cpassword.setMaxAge(60*60*24*7);
//            response.addCookie(cusername);
//            response.addCookie(cpassword);
//        }
//        else {
//            Cookie[] cookies = request.getCookies();
//            if(cookies!=null){
//                for(Cookie cookie:cookies){
//                    if(cookie.getName().equals("cookie_username")||cookie.getName().equals("cookie_password")){
//                        cookie.setMaxAge(0);
//                        response.addCookie(cookie);
//                    }
//                }
//            }
//        }
        modelAndView.addObject("username",username);
        modelAndView.setViewName("index");
        return modelAndView;
    }



    @GetMapping("/login")
    public ModelAndView login( ModelAndView modelAndView ) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}



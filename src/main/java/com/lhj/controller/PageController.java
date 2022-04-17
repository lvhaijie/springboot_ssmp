package com.lhj.controller;

import com.lhj.pojo.User;
import com.lhj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

//@Controller
//@RequestMapping("/toPage")
//
//public class PageController {
//    @RequestMapping("/{brand}")
//    public String brand( @PathVariable String brand ) {
//        return "brand";
//    }
//
//    @RequestMapping("/{login}")
//    public String login(@PathVariable String login) {
//        return "login";
//    }
//
//
//    @RequestMapping("/{register}")
//    public String register(@PathVariable String register) {
//        return "register";
//    }
//
//}

@Controller

public class PageController implements WebMvcConfigurer {
    @RequestMapping("/brand")
    public String brand(  ) {
        return "brand";
    }

    @RequestMapping("/index")
    public String index(  ) {
        return "index";
    }

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ModelAndView logincheck( ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, String remember, HttpServletRequest request, HttpServletResponse response ) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String username = user.getUsername();
        String password = user.getPassword();
        User name = loginService.selectByName(username);
        if(name==null){

            modelAndView.addObject("error","该用户名不存在!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        User user1=loginService.login(username,password);
        if(user1==null){
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
        modelAndView.setViewName("brand");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login( ModelAndView modelAndView ) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}



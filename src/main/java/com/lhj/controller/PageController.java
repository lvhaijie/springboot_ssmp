package com.lhj.controller;

import com.lhj.pojo.SysUser;
import com.lhj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser sysUser = (SysUser) principal;
        model.addAttribute("name", sysUser.getUsername());
        return "index";
    }

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ModelAndView logincheck( ModelAndView modelAndView, @Valid SysUser sysUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        SysUser name = loginService.selectByName(username);
        if(name==null){

            modelAndView.addObject("error","该用户名不存在!");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        SysUser sysUser1 =loginService.login(username,password);
        if(sysUser1 ==null){
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
//@PostMapping("/login")
//public String logincheck( Model model, @Valid SysUser user, BindingResult bindingResult, String remember, HttpServletRequest request, HttpServletResponse response ) {
//    String username = user.getUsername();
//    model.addAttribute("user",user);
//    model.addAttribute("username",username);
//
//    return "redirect:/index";
//}

    @GetMapping("/login")
    public ModelAndView login( ModelAndView modelAndView ) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
}



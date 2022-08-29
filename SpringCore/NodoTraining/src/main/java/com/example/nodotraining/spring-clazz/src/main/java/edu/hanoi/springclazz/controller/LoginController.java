package edu.hanoi.springclazz.controller;
import org.apache.log4j.Logger;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "error",required = false) String error){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        if (error != null) {
            mv.addObject("error","Sai tên hoặc mật khẩu");
        }
        return mv;
    }
    @RequestMapping("/nguoi-dung")
    public ModelAndView forUser(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("message","Hello User" +auth.getName());
        return mv;
    }
}

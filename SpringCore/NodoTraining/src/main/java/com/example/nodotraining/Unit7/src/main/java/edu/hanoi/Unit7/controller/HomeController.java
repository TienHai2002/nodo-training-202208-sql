package edu.hanoi.Unit7.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "TienHaIsMe");
        return mv;
    }

    @RequestMapping("nguoi-dung")
    public ModelAndView forUser() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "This is protected page!");
        return mv;
    }

//        @RequestMapping("/login")
//    public ModelAndView login(@RequestParam(value = "error",required = false) String error){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("login");
//        if (error != null) {
//            mv.addObject("error","Sai tên hoặc mật khẩu");
//        }
//        return mv;
//    }
    @RequestMapping("/dang-nhap")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        if (error != null) {
            mv.addObject("error", error);
        }
        return mv;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

}

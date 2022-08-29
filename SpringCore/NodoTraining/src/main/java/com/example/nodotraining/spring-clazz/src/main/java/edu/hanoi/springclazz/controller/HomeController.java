package edu.hanoi.springclazz.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final static Logger logger = Logger.getLogger(HomeController.class);
    @RequestMapping("/")

   public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message","Hello Tien Hai");
        logger.info("da truy cap vao day");
        return mv;
    }



}

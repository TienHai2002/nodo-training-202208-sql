package controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloClazzController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printMessage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("message", "Hello Java clazz!");
        return mv;
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../clazz");
        mv.addObject("name", "vjp");
        return mv;
    }

    @RequestMapping(value = "site", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:http://moon.vn";
    }
//Mapping mapping= new Mapping("data" ,GET,produces = MediaType.TEXT_PLAIN_VALUE)
//        public @ResponseBody String raw(){
//        return "xin chao moi ng";
//        }

}
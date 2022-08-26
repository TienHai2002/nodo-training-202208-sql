package controller;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {
    @RequestMapping(value = "student/add",method = RequestMethod.GET)
    public ModelAndView add(){
        return new ModelAndView("student.form","command",new Student());
    }
    @RequestMapping(value = "student/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result){
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("student.form","command",student);
            model.addObject("errors",result);
            return model;
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student.view");
        mv.addObject("student",student);
        return mv;
    }
}

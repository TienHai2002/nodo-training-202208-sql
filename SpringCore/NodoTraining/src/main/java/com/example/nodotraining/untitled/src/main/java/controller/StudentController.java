package controller;

import dao.StudentDAO;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    @RequestMapping(value = "/student/add",method = RequestMethod.GET)
    public ModelAndView add(){
        return new ModelAndView("student.form","command",new Student());
    }
    @RequestMapping(value = "/student/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result){
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("student.form","command",student);
            model.addObject("errors",result);
            return model;
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student.list");
        mv.addObject("student",student);
        studentDAO.insert(student);
        return new ModelAndView("redirect:/student/list");
    }
    @RequestMapping(value = "/student/list",method = RequestMethod.GET)
    public ModelAndView listStudent(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student.list");
        mv.addObject("students",studentDAO.list());
        return mv;
    }
    @RequestMapping(value = "/student/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        studentDAO.deleteById(id);
        return "redirect:/student/list";
    }
    @RequestMapping(value = "/student/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        Student student = studentDAO.getById(id);
        System.out.println("Student: "+student.getName());
        return new ModelAndView("/student/student.form","command",student);
    }
}
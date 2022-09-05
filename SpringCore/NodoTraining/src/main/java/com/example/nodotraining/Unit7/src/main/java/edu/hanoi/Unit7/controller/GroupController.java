package edu.hanoi.Unit7.controller;


import edu.hanoi.Unit7.dao.GroupDAO;
import edu.hanoi.Unit7.model.Group;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/nhom")
public class GroupController {
    @Autowired
    private GroupDAO groupDAO;

    private final static Logger LOGGER = Logger.getLogger(GroupController.class);

    @GetMapping("/them")
    public String addForm(@ModelAttribute("command") Group group){
        return "form";
    }

    @PostMapping("/luu")
    public String addNew(@Valid @ModelAttribute("command") Group group, BindingResult result, Model model, @RequestParam("id")Optional<Integer> id){
        if (result.hasErrors()){
            model.addAttribute("errors", result);
        }
        if (id.isPresent()) {
            groupDAO.update(group);
            LOGGER.info("update group --------> " + group);
        }
        else {
            groupDAO.insert(group);
            LOGGER.info("add new group --------> " + group);
        }
        return "redirect:/nhom/danh-sach";
    }

    @GetMapping("/danh-sach")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("groups", groupDAO.list());
        return mv;
    }

    @GetMapping("/xoa/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        if (id == null) return new ModelAndView("redirect:/nhom/danh-sach");
        groupDAO.delete(id);
        return new ModelAndView("redirect:/nhom/danh-sach");
    }

    @GetMapping("/sua")
    public String updateForm(@RequestParam(value = "id", required = true) Integer id, Model model){
        Group group = groupDAO.get(id);
        model.addAttribute("command",group);
        if (group == null) return "redirect:/nhom/danh-sach";
        return "form";
    }

}

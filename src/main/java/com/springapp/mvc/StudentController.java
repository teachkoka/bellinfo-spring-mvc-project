package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by iue820 on 2/6/16.
 */
@Controller
@RequestMapping(value ="/student")
public class StudentController {


    @RequestMapping(value="", method = RequestMethod.GET)
    public String getStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-login";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String studentDetails(@Valid @ModelAttribute Student student, BindingResult result, Model model){

        if(result.hasErrors()){
            return "student-login";
        }
        model.addAttribute("message", "Hey...welcome "+student.getName());
        return "success";
    }
}

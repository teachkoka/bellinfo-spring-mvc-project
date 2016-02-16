package com.springapp.mvc.controller;

import com.springapp.mvc.model.EnrollResponse;
import com.springapp.mvc.model.EnrollStudent;
import com.springapp.mvc.model.Student;
import com.springapp.mvc.model.StudentShow;
import com.springapp.mvc.service.EnrollStudentServiceImpl;
import com.springapp.mvc.service.UpdateStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by iue820 on 2/6/16.
 */
@Controller
@RequestMapping(value ="/student")
public class StudentController {

    @Autowired
    EnrollStudentServiceImpl enrollStudentService;

    @Autowired
    UpdateStudentServiceImpl updateStudentService;


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String studentDetails(@Valid @ModelAttribute Student student, BindingResult result, Model model){

        if(result.hasErrors()){
            return "student-login";
        }
        model.addAttribute("message", "Hey...welcome "+student.getName());
        return "success";
    }

    @RequestMapping(value="/enroll", method= RequestMethod.GET)
    public String enrollStudent(Model model){
        EnrollStudent enrollStudent = new EnrollStudent();
        model.addAttribute("enrollStudent",enrollStudent);
        return "enroll-student";
    }

    @RequestMapping(value="/enroll", method= RequestMethod.POST)
    public String enrollStudent(@Valid @ModelAttribute EnrollStudent enrollStudent, BindingResult result, Model model){
        if(result.hasErrors()){
            return "enroll-student";
        }
        int id =enrollStudentService.enrollStudent(enrollStudent);
        EnrollResponse e = new EnrollResponse();
        e.setStudentUniqueId(id);
        e.setStudentName(enrollStudent.getName());
        model.addAttribute("message", "Welcome "+enrollStudent.getName()+"! Welcome to the part of Bellinfo");
        model.addAttribute("enrollResponse", e);
        return "success";
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String listOfEnrolledStudents(Model model){
        List<StudentShow> studentList = enrollStudentService.getStudents();
        model.addAttribute("list", studentList);
        return "enroll-details";
    }

    @RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
    public String modifyStudentInfo(@PathVariable Integer id, Model model ){
        StudentShow studentShow = enrollStudentService.getStudent(id);
        model.addAttribute("studentShow", studentShow);
        return "edit-form";
    }

    @RequestMapping(value="/edit/{id}", method= RequestMethod.POST)
    public String modifyStudentInfo(@ModelAttribute StudentShow studentShow, @PathVariable Integer id, Model model ){
        enrollStudentService.updateStudentInfo(studentShow);
        model.addAttribute("message", "updated successfully");
        return "enroll-details";
    }
}

package com.springapp.mvc.service;

import com.springapp.mvc.model.EnrollStudent;
import com.springapp.mvc.model.StudentShow;
import com.springapp.mvc.respository.EnrollStudentRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iue820 on 2/15/16.
 */
@Service
@Transactional
public class EnrollStudentServiceImpl {

       @Autowired
       EnrollStudentRespositoryImpl enrollStudentRespository;

       public int enrollStudent(EnrollStudent student){
          return enrollStudentRespository.addStudent(student);
       }
       public List<StudentShow> getStudents(){
           return enrollStudentRespository.getStudents();
       }
       public StudentShow getStudent(Integer id){
           return enrollStudentRespository.getStudent(id);
       }

       public void updateStudentInfo(StudentShow ss){
         enrollStudentRespository.updateStudentInfo(ss);
       }
}

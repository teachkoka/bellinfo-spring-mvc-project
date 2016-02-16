package com.springapp.mvc.respository;

import com.springapp.mvc.model.EnrollStudent;
import com.springapp.mvc.model.StudentShow;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iue820 on 2/15/16.
 */
@Repository
public class EnrollStudentRespositoryImpl {

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    public int addStudent(EnrollStudent student){
        Integer integer = (Integer) getSession().save(student);
        return integer.intValue();
    }

    public List<StudentShow> getStudents(){
        Criteria criteria = getSession().createCriteria(EnrollStudent.class);
        Projection pId= Projections.property("id");
        Projection pName = Projections.property("name");
        Projection pEmail= Projections.property("email");

        ProjectionList pl = Projections.projectionList();

        pl.add(pId);
        pl.add(pName);
        pl.add(pEmail);
        criteria.setProjection(pl);

        List<Object> list = criteria.list();
        List<StudentShow> lshow = new ArrayList<>();
        StudentShow s1 ;
        for(Object o: list){
            Object[] array= (Object[])o;
            s1 = new StudentShow();
            s1.setId(array[0].toString());
            s1.setName(array[1].toString());
            s1.setEmail(array[2].toString());
            lshow.add(s1);
        }
       return lshow;


    }


    public StudentShow getStudent(Integer id){

        Criteria criteria = getSession().createCriteria(EnrollStudent.class);
        Projection pId= Projections.property("id");
        Projection pName = Projections.property("name");
        Projection pEmail= Projections.property("email");

        ProjectionList pl = Projections.projectionList();

        pl.add(pId);
        pl.add(pName);
        pl.add(pEmail);
        criteria.setProjection(pl);
        Criterion c =Restrictions.eq("id", id);
        criteria.add(c);
        Object obj = criteria.uniqueResult();
        Object[] array = (Object[])obj;
        StudentShow ss= new StudentShow();
        ss.setId(array[0].toString());
        ss.setName(array[1].toString());
        ss.setEmail(array[2].toString());
        return ss;
    }

    public void updateStudentInfo(StudentShow ss){
        String updateHql = "update EnrollStudent set name=:name, email=:email where id=:id";
        Query query = getSession().createQuery(updateHql);
        query.setInteger("id", new Integer(ss.getId()));
        query.setString("name", ss.getName());
        query.setString("email", ss.getEmail());
        query.executeUpdate();

    }

}

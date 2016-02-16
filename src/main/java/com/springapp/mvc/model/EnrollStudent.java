package com.springapp.mvc.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by iue820 on 2/15/16.
 */

@Entity
@Table(name="ENROLL_STUDENT")
public class EnrollStudent {
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enroll_seq")
    @SequenceGenerator(name = "enroll_seq", sequenceName = "enroll_seq")*/

    @Id
    @Column(name="STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="STUDENT_NAME",nullable = false)
    private String name;

    @Email
    @Column(name="STUDENT_EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @NotEmpty
    @Column(name="TECHNOLOGY")
    private String technology;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "EnrollStudent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

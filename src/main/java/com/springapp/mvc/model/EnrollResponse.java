package com.springapp.mvc.model;

/**
 * Created by iue820 on 2/15/16.
 */
public class EnrollResponse {

    private int studentUniqueId;
    private String studentName;

    public int getStudentUniqueId() {
        return studentUniqueId;
    }

    public void setStudentUniqueId(int studentUniqueId) {
        this.studentUniqueId = studentUniqueId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "EnrollResponse{" +
                "studentUniqueId=" + studentUniqueId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

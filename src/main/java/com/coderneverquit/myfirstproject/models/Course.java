package com.coderneverquit.myfirstproject.models;

public class Course {
   private Integer courseID;
   private String courseName;
   private String courseIntructor;
    public Course(Integer courseID, String courseName, String courseIntructor) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseIntructor = courseIntructor;
    }
    public Integer getCourseID() {
        return courseID;
    }
    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseIntructor() {
        return courseIntructor;
    }
    public void setCourseIntructor(String courseIntructor) {
        this.courseIntructor = courseIntructor;
    }
    @Override
    public String toString() {
        return "Course [courseID=" + courseID + ", courseIntructor=" + courseIntructor + ", courseName=" + courseName
                + "]";
    }
    
   
}

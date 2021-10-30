package com.coderneverquit.myfirstproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coderneverquit.myfirstproject.models.Course;
import com.coderneverquit.myfirstproject.repos.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> allCourses(){
        List<Course> ac = courseRepository.findAll();
        return ac;
    }

    public Optional<Course> singleCourse(Integer courseID) throws Exception{
        Optional<Course> singleCourse = courseRepository.findById(courseID);
 
        if(!singleCourse.isPresent()){
            throw new Exception("couse is not available");
        }
        return singleCourse;
     }

     public String updateCourse(Integer courseID, Course updatedCourseData){
                 courseRepository.updateCourseById(
                 updatedCourseData.getCourseName(),
                 updatedCourseData.getCourseIntructor(), 
                 courseID
                 );
             return "Course Updated";
        }

       public String deleteCourse(Integer courseID){
                courseRepository.deleteById(courseID);
                return "Course deleted";
        }

        public String postCourse(Course course){
          courseRepository.save(course);
          return "saved success";
        }
   
        public List<Course> findByCourseIntructor(String name){
            return courseRepository.findByCourseIntructor(name);
        }
        public List<Course> findByCourseContaining(String name){
            return courseRepository.findByCourseNameContaining(name);
        }
}

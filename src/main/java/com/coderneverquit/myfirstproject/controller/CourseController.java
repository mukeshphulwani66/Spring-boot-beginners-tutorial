package com.coderneverquit.myfirstproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coderneverquit.myfirstproject.models.Course;
import com.coderneverquit.myfirstproject.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(path="/api")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> allCourses(){
      return courseService.allCourses();
    }
    @GetMapping("/courses/{cid}")
    public Optional<Course> singleCourse(@PathVariable("cid") Integer courseID) throws Exception{
      try{
        return courseService.singleCourse(courseID);
      }catch(Exception exception){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage());
      }
      
    }
    @PutMapping("/courses/{cid}")
    public List<Course> updateCourse(@PathVariable("cid") Integer courseID,@RequestBody Course updatedCourseData){
      return courseService.updateCourse(courseID, updatedCourseData);
    }
    @DeleteMapping("/courses/{cid}")
    public List<Course> deleteCourse(@PathVariable("cid") Integer courseID){
         return courseService.deleteCourse(courseID);
    }
    @PostMapping("/postcourse")
    public List<Course> postCourse(@RequestBody Course course) throws Exception{
      try{
          return courseService.postCourse(course);
      }catch(Exception exception){
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,exception.getMessage());
      }
    
    }
}

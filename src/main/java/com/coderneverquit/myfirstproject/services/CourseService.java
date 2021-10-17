package com.coderneverquit.myfirstproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coderneverquit.myfirstproject.models.Course;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
    private List<Course> allcourses = new ArrayList<>();

    public CourseService() {
       allcourses.add(new Course(101, "React.js", "Mukesh"));
       allcourses.add(new Course(102, "Angular", "Suresh"));
       allcourses.add(new Course(103, "Java", "Ramesh"));
    }

    public List<Course> allCourses(){
        System.out.println(allcourses);
        return allcourses;
    }

    public Optional<Course> singleCourse(Integer courseID) throws Exception{
        Optional<Course> singleCourse = allcourses.stream()
                              .filter(course -> courseID.equals(course.getCourseID()))
                              .findAny();
 
        if(!singleCourse.isPresent()){
            throw new Exception("couse is not available");
        }
        return singleCourse;
     }

     public List<Course> updateCourse(Integer courseID, Course updatedCourseData){
        Course singleCourse = allcourses.stream()
                              .filter(course -> courseID.equals(course.getCourseID()))
                              .findAny()
                              .orElse(new Course(404,"not found","not found"));
 
            
                    
                    allcourses.set(allcourses.indexOf(singleCourse), updatedCourseData);
                    return allcourses;
                }

       public List<Course> deleteCourse(Integer courseID){
                allcourses.removeIf(course -> courseID.equals(course.getCourseID()));
                return allcourses;
        }

        public List<Course> postCourse(Course course) throws Exception{

            Optional<Course> singleCourse = allcourses.stream()
            .filter(c -> course.getCourseID().equals(c.getCourseID()))
            .findAny();

            if(singleCourse.isPresent()){
                throw new Exception("Couse with this id is already exists");
            }

           allcourses.add(course);
          return allcourses;
        }
   
}

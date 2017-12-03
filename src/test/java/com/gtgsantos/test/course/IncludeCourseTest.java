package com.gtgsantos.test.course;

import org.junit.Test;

import com.gtgsantos.domain.course.Course;
import com.gtgsantos.repository.CourseRepository;

public class IncludeCourseTest {
    
    private static CourseRepository repository = new CourseRepository();

    @Test
    public void insertOne() {
        Course course = new Course();
        course.setName("Java 101");
        
        repository.save(course);
        
        Course course2 = repository.find(course.getPk());
        System.out.println("have id? " + course2.getPk() != null);
    }
    
    
    @Test
    public void insertTwo() {
        Course course = new Course();
        course.setName("Java 101");
        repository.save(course);
         
        Course course1 = new Course();
        course1.setName("Java 102");
        course1.addAdditionalCourse(course);
        repository.save(course1);
        
        Course course3 = repository.find(course1.getPk());
        Course course2 = repository.find(course.getPk());
        System.out.println("exists additional? " + !(course3.getAdditionalCourses() == null 
                || course3.getAdditionalCourses().size() == 0));
        System.out.println("exists master? " +  course2.getMaster() != null);
        
    }
    
    
}

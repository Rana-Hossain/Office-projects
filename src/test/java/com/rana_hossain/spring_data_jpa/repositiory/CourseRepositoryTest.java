package com.rana_hossain.spring_data_jpa.repositiory;

import com.rana_hossain.spring_data_jpa.entity.Course;
import com.rana_hossain.spring_data_jpa.entity.Student;
import com.rana_hossain.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Course :" +courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("rana")
                .lastName("hassain")
                .build();
        Course course = Course.builder()
                .title("C++")
                .credit(9)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = (Pageable) PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = (Pageable) PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        System.out.println("Course :" +courses);
    }
}
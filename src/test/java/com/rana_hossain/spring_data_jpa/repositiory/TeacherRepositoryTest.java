package com.rana_hossain.spring_data_jpa.repositiory;

import com.rana_hossain.spring_data_jpa.entity.Course;
import com.rana_hossain.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDSA = Course.builder()
                .title("DSA")
                .credit(5)
                .build();
        Course courseJAVA = Course.builder()
                .title("Java")
                .credit(8)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Arif")
                .lastName("Hasan")
                //.courseList(List.of(courseDSA,courseJAVA))
                .build();
        teacherRepository.save(teacher);
    }
}
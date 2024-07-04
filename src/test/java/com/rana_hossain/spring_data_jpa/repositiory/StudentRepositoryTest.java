package com.rana_hossain.spring_data_jpa.repositiory;

import com.rana_hossain.spring_data_jpa.entity.Guardian;
import com.rana_hossain.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("rana")
                .lastName("hossain")
                .emailId("rana@hossain.com")
                //.guardianEmail("guard@gmail.com")
                //.guardianMobile("0192312345")
                //.guardianName("guard")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {

        List <Student> students = studentRepository.findAll();

        System.out.println("students List : " + students);
    }

    @Test
    public void saveStudentWIthGuardianClass(){
        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .mobile("0192312345")
                .name("guard")
                .build();
        Student student = Student.builder()
                .firstName("demo")
                .lastName("hossain")
                .emailId("rh@hossain.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List <Student> students = studentRepository.findByFirstName("rana");
        System.out.println("students List : " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List <Student> students = studentRepository.findByFirstNameContaining("ra");
        System.out.println("students List : " + students);
    }

    @Test
    public void printgetStudentsByEmailAddress(){
        Student student = studentRepository.getStudentsByEmailAddress("rana@hossain.com");
        System.out.println("students List : " + student);
    }

    @Test
    public void printgetStudentsFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentsFirstNameByEmailAddress("rana@hossain.com");
        System.out.println("students Name : " + firstName);
    }

    @Test
    public void printgetStudentsByEmailAddressNative(){
        Student student = studentRepository.getStudentsByEmailAddressNative("rana@hossain.com");

        System.out.println("students List : " + student);
    }

    @Test
    public void printgetStudentsByEmailAddressNativeNameParams(){
        Student student = studentRepository.getStudentsByEmailAddressNativeNameParam("rana@hossain.com");

        System.out.println("students List : " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("haha", "rana@hossain.com");
    }

}
package com.rana_hossain.spring_data_jpa.repositiory;

import com.rana_hossain.spring_data_jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

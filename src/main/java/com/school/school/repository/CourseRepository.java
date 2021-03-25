package com.school.school.repository;

import com.school.school.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {

    Course findByName(final String name);

    Course findByNameEqualsAndStatus(final String name,final String status);

    List<Course> findAllByStatus(final String status);

    List<Course> findByStatus(final String status);


}

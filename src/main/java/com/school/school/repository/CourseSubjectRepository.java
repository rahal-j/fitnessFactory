package com.school.school.repository;

import com.school.school.entity.CourseSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseSubjectRepository extends JpaRepository<CourseSubject, Long> {

    @Modifying
    @Query("delete from CourseSubject cs where cs.courseId = :id")
    void deleteSubjects(@Param("id")long course);

    @Query("select cs from CourseSubject cs")
    List<CourseSubject> find();

    @Query("select cs from CourseSubject cs where cs.courseId = :courseId")
    List<CourseSubject> find(@Param("courseId")long id);


 }

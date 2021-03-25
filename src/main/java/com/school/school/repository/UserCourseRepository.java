package com.school.school.repository;

import com.school.school.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourse,Long> {



  //  UserCourse findByUserId(final long id);


    @Query(value = "SELECT DISTINCT course_id FROM user_course where user_id =?", nativeQuery =
            true)
    List<UserCourse> getUserCoursesFromUserId(long userId);


    List<UserCourse> findByUserId(long userId);
}

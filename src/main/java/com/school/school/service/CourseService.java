package com.school.school.service;

import com.school.school.dto.CourseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Course;

public interface CourseService {
    ResponseDto saveCourse(CourseDto courseDto);

    ResponseDto deleteCourse(long id);

    ResponseDto updateCourse(CourseDto courseDto);

    ResponseDto deactivateCourse(long id);

    ResponseDto activateCourse(long id);

    ResponseDto fetchAll();

    ResponseDto getCourseData(long id);

    ResponseDto getActiveCourses();

    Course getCourse(long id);
}

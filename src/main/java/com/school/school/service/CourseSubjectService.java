package com.school.school.service;

import com.school.school.dto.CourseSubjectDto;
import com.school.school.dto.ResponseDto;

public interface CourseSubjectService {
    ResponseDto saveCourseSubject(CourseSubjectDto courseSubjectDto);

    ResponseDto getCourseSubject(long courseId );

    ResponseDto getCourseFromId(long id);

    ResponseDto getSubjectListFromCourse(long id);
}

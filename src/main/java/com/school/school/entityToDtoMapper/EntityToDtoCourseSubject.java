package com.school.school.entityToDtoMapper;

import com.school.school.dto.CourseSubjectDto;
import com.school.school.entity.CourseSubject;

public class EntityToDtoCourseSubject {

    public static CourseSubjectDto getCourseSubjectDto(CourseSubjectDto courseSubjectDto, CourseSubject courseSubject){
        courseSubjectDto.setCourse(String.valueOf(courseSubject.getCourseId()));
        //courseSubjectDto.setSubjects(courseSubject.);
        return courseSubjectDto;
    }

}

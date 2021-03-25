package com.school.school.entityToDtoMapper;

import com.school.school.dto.CourseDto;
import com.school.school.dto.SubjectDto;
import com.school.school.entity.Course;
import com.school.school.entity.Subject;
import com.school.school.enums.TransactionStatus;

public class EntityToDtoCourse {

    public static CourseDto getCourseDto(CourseDto courseDto, Course course){
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setStatus(TransactionStatus.valueOf(course.getStatus()).getCode());
        courseDto.setStartDate(course.getStartDate());
        courseDto.setEndDate(course.getEndDate());
        return courseDto;
    }

}

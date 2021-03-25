package com.school.school.dtoToEntityMapper;

import com.school.school.dto.CourseDto;
import com.school.school.entity.Course;
import com.school.school.enums.TransactionStatus;

public class DtoToEntityCourse {


    public static Course getCourse(Course course, CourseDto courseDto){
        course.setId(courseDto.getId() != null?courseDto.getId():null);
        course.setName(courseDto.getName());
        course.setStatus(TransactionStatus.valueOf(courseDto.getStatus()).getCode().toUpperCase());
        course.setStartDate(courseDto.getStartDate());
        course.setEndDate(courseDto.getEndDate());
        return course;
    }
}

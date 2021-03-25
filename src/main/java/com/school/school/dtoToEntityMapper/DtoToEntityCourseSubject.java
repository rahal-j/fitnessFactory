package com.school.school.dtoToEntityMapper;

import com.school.school.dto.CourseSubjectDto;
import com.school.school.entity.CourseSubject;
import com.school.school.enums.TransactionStatus;

import java.util.Date;

public class DtoToEntityCourseSubject {


    public static CourseSubject getCourse(CourseSubject courseSubject,String course, String subject){

//        CourseSubject.CourseSubjectId courseSubjectId = new CourseSubject.CourseSubjectId();
//        courseSubjectId.setCourseId(Long.parseLong(course));
//        courseSubjectId.setSubjectId(Long.parseLong(subject));
//        courseSubject.setCourseSubjectId(courseSubjectId);
        courseSubject.setCourseId(Long.parseLong(course));
        courseSubject.setSubjectId(Long.parseLong(subject));
        courseSubject.setStatus(TransactionStatus.ACTIVE.getCode());
        courseSubject.setDateAdded(new Date());
        return courseSubject;
    }




}
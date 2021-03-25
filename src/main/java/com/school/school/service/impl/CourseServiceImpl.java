package com.school.school.service.impl;

import com.school.school.dto.CourseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubjectDto;
import com.school.school.dtoToEntityMapper.DtoToEntityCourse;
import com.school.school.dtoToEntityMapper.DtoToEntitySubject;
import com.school.school.entity.Course;
import com.school.school.entity.Subject;
import com.school.school.entityToDtoMapper.EntityToDtoCourse;
import com.school.school.entityToDtoMapper.EntityToDtoSubject;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.CourseRepository;
import com.school.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CourseServiceImpl implements CourseService {


    @Autowired
    CourseRepository courseRepository;

    @Override
    public ResponseDto saveCourse(CourseDto courseDto){

        try {
            courseRepository.save(DtoToEntityCourse.getCourse(new Course(),courseDto));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Course Succesfully Updated !");
        }catch (Exception e){
            return new ResponseDto(ResponseEnum.FAIL.getCode(),"Course Already Exist !");
        }

    }

    @Override
    public ResponseDto deleteCourse(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Course subject = courseRepository.getOne(id);
        if(subject != null) {
            subject.setStatus(TransactionStatus.DEACTIVE.getCode());
            courseRepository.save(subject);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Course deleted successfully");
        }
        return responseDto;
    }

    @Override
    public ResponseDto updateCourse(CourseDto courseDto){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Course subject = courseRepository.findByName(courseDto.getName());
        if(subject != null){
            courseRepository.save(DtoToEntityCourse.getCourse(subject,courseDto));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Course updated successfully");

        }
        return responseDto;
    }


    @Override
    public ResponseDto deactivateCourse(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Course subject = courseRepository.getOne(id);
        if(subject != null) {
            subject.setStatus(TransactionStatus.DEACTIVE.getCode());
            courseRepository.save(subject);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Course deactivated successfully");
        }
        return responseDto;
    }

    @Override
    public ResponseDto activateCourse(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Course subject = courseRepository.getOne(id);
        if(subject != null) {
            subject.setStatus(TransactionStatus.ACTIVE.getCode());
            courseRepository.save(subject);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Class room activated successfully");
        }
        return responseDto;


    }

    @Override
    public ResponseDto fetchAll(){
        return new ResponseDto(courseRepository.findAll());
    }




    @Override
    public ResponseDto getCourseData(final long id){

        return new ResponseDto(EntityToDtoCourse.getCourseDto(new CourseDto(),courseRepository.getOne(id)));
    }

    @Transactional
    @Override
    public ResponseDto getActiveCourses(){
         return  new ResponseDto(courseRepository.findByStatus(TransactionStatus.ACTIVE.getCode()));
    }

    @Transactional
    @Override
    public Course getCourse(long id){
        return courseRepository.getOne(id);
    }



}

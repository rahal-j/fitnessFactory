package com.school.school.service.impl;

import com.school.school.dto.CourseSubjectDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubjectDto;
import com.school.school.dtoToEntityMapper.DtoToEntityCourseSubject;
import com.school.school.entity.CourseSubject;
import com.school.school.entity.Subject;
import com.school.school.enums.ResponseEnum;
import com.school.school.repository.CourseRepository;
import com.school.school.repository.CourseSubjectRepository;
import com.school.school.repository.SubjectRepository;
import com.school.school.service.CourseSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseSubjectServiceImpl implements CourseSubjectService {


    @Autowired
    CourseSubjectRepository courseSubjectRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Transactional
    @Override
    public ResponseDto saveCourseSubject(CourseSubjectDto courseSubjectDto) {

        try {
            List<CourseSubject> courseSubjects = courseSubjectRepository.find();
            if (courseSubjects.size() > 0) {
                courseSubjectRepository.deleteSubjects(Long.parseLong(courseSubjectDto.getCourse()));
            }
            List<CourseSubject> collect = courseSubjectDto.getSubjects().stream().map(
                    t -> DtoToEntityCourseSubject.getCourse(new CourseSubject(), courseSubjectDto.getCourse(), t)
            ).collect(Collectors.toList());
            collect.forEach(x -> courseSubjectRepository.save(x));

            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), "Course Succesfully Updated !");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto(ResponseEnum.FAIL.getCode(), "Course Already Exist !");
        }

    }

    @Transactional
    @Override
    public ResponseDto getCourseSubject(long id) {
        List<CourseSubject> courseSubject = courseSubjectRepository.find(id);

        CourseSubjectDto courseSubjectDto = new CourseSubjectDto();
         List<String> subjects = new ArrayList<>();
        courseSubject.stream().forEach(courseSubject1 -> {
            subjects.add(subjectRepository.getOne(courseSubject1.getSubjectId()).getName());
        });
        courseSubjectDto.setSubjects(subjects);

        return new ResponseDto(courseSubjectDto);

    }

    @Override
    @Transactional
    public ResponseDto getCourseFromId(long id){
        return new ResponseDto(courseRepository.getOne(id));
    }


    @Transactional
    @Override
    public ResponseDto getSubjectListFromCourse(long id){
        List<CourseSubject> courseSubject = courseSubjectRepository.find(id);
        List<SubjectDto> subjectDtos = new ArrayList<>();
        courseSubject.stream().forEach(courseSubject1 -> {
            SubjectDto subjectDto = new SubjectDto();
            Subject subject = subjectRepository.getOne(courseSubject1.getSubjectId());
            subjectDto.setId(subject.getId());
            subjectDto.setName(subject.getName());
            subjectDtos.add(subjectDto);
        });
        return new ResponseDto(subjectDtos);
    }



}

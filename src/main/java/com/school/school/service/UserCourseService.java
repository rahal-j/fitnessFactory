package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.UserCourseDto;

public interface UserCourseService {
    ResponseDto fetchAll();

    ResponseDto saveUserCourse(UserCourseDto userCourseDto);

    ResponseDto getUserCourseData(long id);

    ResponseDto getCourseFromNic(long id);

    ResponseDto getClassTimeForMember(long userId);
}

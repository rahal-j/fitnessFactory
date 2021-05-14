package com.school.school.dtoToEntityMapper;

import com.school.school.dto.AttendanceDto;
import com.school.school.entity.Attendance;
import com.school.school.entity.Member;

import java.util.Date;

public class AttendanceDtoToEntityMapper {

    public static Attendance getAttendanceEntity(AttendanceDto attendanceDto, Attendance attendance, Member member){

        attendance.setId(attendanceDto.getId());
        attendance.setDate(new Date());
        attendance.setMemberId(member);

        return attendance;




    }



}

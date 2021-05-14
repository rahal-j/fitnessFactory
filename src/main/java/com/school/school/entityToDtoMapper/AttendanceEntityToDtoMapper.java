package com.school.school.entityToDtoMapper;

import com.school.school.dto.AttendanceDto;
import com.school.school.entity.Member;

public class AttendanceEntityToDtoMapper {

    public static AttendanceDto getAttendanceDto(Member member){
        AttendanceDto attendanceDto = new AttendanceDto();
        attendanceDto.setMemberId(member.getId());

        return attendanceDto;



    }


}

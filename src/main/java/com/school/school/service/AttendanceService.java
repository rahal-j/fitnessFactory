package com.school.school.service;

import com.school.school.dto.AttendanceDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    ResponseDto addAttendance(AttendanceDto attendanceDto);

    List<Attendance> fetchAttendance();

    ResponseDto getAttendanceDto(String nic);

    List<Attendance> getMemberAttendance(int memberId);
}

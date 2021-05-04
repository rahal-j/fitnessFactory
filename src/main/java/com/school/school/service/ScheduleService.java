package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.ScheduleDto;
import com.school.school.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    ResponseDto addSchedule(ScheduleDto scheduleDto);

    List<Schedule> fetchSchedule();


    ResponseDto getScheduleDto(String nic);

    ResponseDto saveScheduleArray(ScheduleDto scheduleDto);
}

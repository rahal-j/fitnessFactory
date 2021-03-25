package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.RoomScheduleDto;

import java.util.Map;

public interface RoomScheduleService {
    ResponseDto fetchAll();

    ResponseDto saveRoomSchedule(RoomScheduleDto roomScheduleDto);

    ResponseDto findRecordsFromToday();

    ResponseDto deactivateSchedule(long id);

    ResponseDto activateSchedule(long id);

    Map<String, Object> getRoomScheduleData(long id);
}

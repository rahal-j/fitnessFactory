package com.school.school.entityToDtoMapper;

import com.school.school.dto.RoomScheduleDto;
import com.school.school.entity.RoomCourseSchedule;
import com.school.school.enums.TransactionStatus;

public class EntityToDtoRoomCourse {


    public static RoomScheduleDto getRoomScheduleDto(RoomScheduleDto roomScheduleDto, RoomCourseSchedule roomCourseSchedule){
        roomScheduleDto.setId(roomCourseSchedule.getId());
        roomScheduleDto.setCourse(roomCourseSchedule.getCourse().getId());
        roomScheduleDto.setRoom(String.valueOf(roomCourseSchedule.getRoom().getId()));
        roomScheduleDto.setStatus(TransactionStatus.valueOf(roomCourseSchedule.getStatus()).getCode());
        roomScheduleDto.setStartTime(String.valueOf(roomCourseSchedule.getStartTime()));
        roomScheduleDto.setEndTime(String.valueOf(roomCourseSchedule.getEndTime()));
        return roomScheduleDto;
    }
}

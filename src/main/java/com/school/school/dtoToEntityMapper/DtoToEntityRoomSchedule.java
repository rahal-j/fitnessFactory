package com.school.school.dtoToEntityMapper;

import com.school.school.dto.CourseDto;
import com.school.school.dto.RoomScheduleDto;
import com.school.school.entity.Course;
import com.school.school.entity.Room;
import com.school.school.entity.RoomCourseSchedule;
import com.school.school.enums.TransactionStatus;

import java.sql.Timestamp;

public class DtoToEntityRoomSchedule {


    public static RoomCourseSchedule getRoomSchedule(RoomCourseSchedule roomCourseSchedule, RoomScheduleDto roomScheduleDto, Course course, Timestamp startTime, Timestamp endTime, Room room){
        roomCourseSchedule.setId(roomScheduleDto.getId() != null?roomScheduleDto.getId():null);
        roomCourseSchedule.setRoom(room);
        roomCourseSchedule.setCourse(course);
        roomCourseSchedule.setStatus(TransactionStatus.valueOf(roomScheduleDto.getStatus()).getCode().toUpperCase());
        roomCourseSchedule.setStartTime(startTime);
        roomCourseSchedule.setEndTime(endTime);
        return roomCourseSchedule;
    }}

package com.school.school.dtoToEntityMapper;

import com.school.school.dto.ScheduleDto;
import com.school.school.entity.Exercise;
import com.school.school.entity.Member;
import com.school.school.entity.Schedule;

import java.util.Date;

public class ScheduleDtoToEntityMapper {
    public static Schedule getScheduleEntity(ScheduleDto scheduleDto, Schedule schedule, Exercise exercise, Member member){

        schedule.setScheduleId(schedule.getScheduleId() !=null? schedule.getScheduleId() : scheduleDto.getId());
        schedule.setExerciseId(exercise);
        schedule.setName(scheduleDto.getName());
        schedule.setDate(new Date());
        schedule.setReps(scheduleDto.getReps());
        schedule.setSets(scheduleDto.getSets());
        schedule.setMemberId(member);
        schedule.setScheduleNo(scheduleDto.getScheduleNo());

        return schedule;



    }

























}

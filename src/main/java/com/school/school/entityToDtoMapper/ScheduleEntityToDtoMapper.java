package com.school.school.entityToDtoMapper;

import com.school.school.dto.ScheduleDto;
import com.school.school.entity.Member;

public class ScheduleEntityToDtoMapper {

    public static ScheduleDto getScheduleDto(Member member){
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setMemberStatus(member.getStatus());
        scheduleDto.setFirstName(member.getFirstName());
        scheduleDto.setLastName(member.getLastName());
        scheduleDto.setTitle(member.getTitle());
        scheduleDto.setEmail(member.getEmail());

        return scheduleDto;


    }






















}

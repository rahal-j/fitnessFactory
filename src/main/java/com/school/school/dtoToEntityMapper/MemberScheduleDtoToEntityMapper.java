package com.school.school.dtoToEntityMapper;

import com.school.school.dto.MemberScheduleDto;
import com.school.school.entity.MemberSchedule;
import org.springframework.stereotype.Component;

@Component
public class MemberScheduleDtoToEntityMapper {

    public static MemberSchedule getMemberScheduleEntity(MemberScheduleDto memberScheduleDto, MemberSchedule memberSchedule) {

        memberSchedule.setId(memberSchedule.getId() !=null? memberSchedule.getId(): null);
        memberSchedule.setMemberId(memberSchedule.getMemberId());
        memberSchedule.setExerciseId(memberSchedule.getExerciseId());
        memberSchedule.setScheduleId(memberSchedule.getScheduleId());
        memberSchedule.setNoOfReps(memberSchedule.getNoOfReps());
        memberSchedule.setNoOfSets(memberSchedule.getNoOfSets());
        memberSchedule.setStatus(memberSchedule.getStatus());
        memberSchedule.setDateCreated(memberSchedule.getDateCreated());
        return memberSchedule;


    }



}

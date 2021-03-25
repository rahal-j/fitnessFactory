package com.school.school.service;

import com.school.school.dto.MemberScheduleDto;
import com.school.school.entity.MemberSchedule;

public interface MemberScheduleService {

    MemberSchedule addMemberSchedule(MemberScheduleDto memberScheduleDto);
}

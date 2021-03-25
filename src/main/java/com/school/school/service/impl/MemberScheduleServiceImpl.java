package com.school.school.service.impl;

import com.school.school.dto.MemberScheduleDto;
import com.school.school.dtoToEntityMapper.MemberScheduleDtoToEntityMapper;
import com.school.school.entity.MemberSchedule;
import com.school.school.repository.MemberScheduleDao;
import com.school.school.service.MemberScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberScheduleServiceImpl implements MemberScheduleService {

    @Autowired
    private MemberScheduleDao memberScheduleDao;

    @Override
    public MemberSchedule addMemberSchedule(MemberScheduleDto memberScheduleDto){
        MemberSchedule memberSchedule = MemberScheduleDtoToEntityMapper.getMemberScheduleEntity(memberScheduleDto, new MemberSchedule());
        return memberScheduleDao.save(memberSchedule);


    }

}

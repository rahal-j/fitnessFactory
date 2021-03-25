package com.school.school.controller;

import com.school.school.dto.MemberScheduleDto;
import com.school.school.entity.MemberSchedule;
import com.school.school.service.MemberScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("memberSchedule")
@Controller
public class MemberScheduleController {

    @Autowired
    private MemberScheduleService memberScheduleService;

    @RequestMapping("/")
    public String addPage(){return "member_schedule_form";}

    @PostMapping("/saveMemberSchedule")
    @ResponseBody
    public MemberSchedule saveMemberSchedule(@RequestBody MemberScheduleDto memberScheduleDto){
        return memberScheduleService.addMemberSchedule(memberScheduleDto);

    }




}

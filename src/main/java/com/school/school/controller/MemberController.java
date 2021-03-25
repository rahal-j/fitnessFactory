package com.school.school.controller;


import com.school.school.dto.MemberDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.service.MemberService;
import com.school.school.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("member")
@Controller
public class MemberController {


    @Autowired
    private MemberService memberService;

    @Autowired
    private SubscriptionService subscriptionService;


    @RequestMapping("/")
    public String addMember(Model model){
        model.addAttribute("members", memberService.fetchMember());
        return "member_list";
    }




    @GetMapping("/insertPage")
    public String addPage(Model model) {

        List<SubscriptionDto> subscriptionDtos = subscriptionService.getActiveSubscriptionList();
        model.addAttribute("subscriptions",subscriptionDtos);
        return "member_form";}

    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveMember(@RequestBody MemberDto memberDto){
        return memberService.addMember(memberDto);
    }


    @GetMapping("/activate")
    @ResponseBody
    public ResponseDto activate(@RequestParam int id) {
        return memberService.activate(id);
    }

    @GetMapping("/deactivate")
    @ResponseBody
    public ResponseDto deactivate(@RequestParam int id) {
        return memberService.deactivate(id);
    }



    @GetMapping("/getUpdateData")
    public String getMemberData(@RequestParam int id, Model model) {
        model.addAttribute("member", memberService.getMemberData(id).getData());
        return "member_form";
    }








}

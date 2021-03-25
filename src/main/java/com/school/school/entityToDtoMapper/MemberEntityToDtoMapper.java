package com.school.school.entityToDtoMapper;

import com.school.school.dto.MemberDto;
import com.school.school.entity.Member;
import com.school.school.entity.Subscription;

public class MemberEntityToDtoMapper  {

    public static MemberDto getMemberDto (MemberDto memberDto, Member member,Subscription subscription){
        memberDto.setId(member.getId());
        memberDto.setFirstName(member.getFirstName());
        memberDto.setLastName(member.getLastName());
        memberDto.setEmail(member.getEmail());
        memberDto.setDateCreated(member.getDateCreated());
        memberDto.setEffectiveDate(member.getEffectiveDate());
        memberDto.setExpireDate(member.getExpireDate());
        memberDto.setAddress(member.getAddress());
        memberDto.setStatus(member.getStatus());
        memberDto.setDob(member.getDob());
        memberDto.setContactNo(member.getContactNo());
        memberDto.setEmergencyNo(member.getEmergencyNo());
        memberDto.setGender(member.getGender());
        memberDto.setNic(member.getNic());
        memberDto.setTitle(member.getTitle());
        memberDto.setSubscription(subscription.getId());

        return memberDto;




    }











}

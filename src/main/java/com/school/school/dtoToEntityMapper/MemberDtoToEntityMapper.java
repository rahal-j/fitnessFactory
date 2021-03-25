package com.school.school.dtoToEntityMapper;

import com.school.school.dto.MemberDto;
import com.school.school.entity.Member;
import com.school.school.entity.Subscription;
import com.school.school.enums.TransactionStatus;

import java.util.Date;

public class MemberDtoToEntityMapper {

    public static Member getMemberEntity(MemberDto memberDto, Member member, Subscription subscription){

        member.setId(member.getId() !=null? member.getId() : memberDto.getId());
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setEmail(memberDto.getEmail());
        member.setDateCreated(new Date());
        member.setEffectiveDate(memberDto.getEffectiveDate());
        member.setExpireDate(memberDto.getExpireDate());
        member.setAddress(memberDto.getAddress());
        member.setStatus(TransactionStatus.ACTIVE.getCode());
        member.setDob(memberDto.getDob());
        member.setContactNo(memberDto.getContactNo());
        member.setEmergencyNo(memberDto.getEmergencyNo());
        member.setGender(memberDto.getGender());
        member.setNic(memberDto.getNic());
        member.setTitle(memberDto.getTitle());
        member.setSubscription(subscription);

        return member;




    }


}

package com.school.school.entityToDtoMapper;

import com.school.school.dto.PaymentDto;
import com.school.school.entity.Member;

public class PaymentEntityToDtoMapper {

    public static PaymentDto getPaymentDto(PaymentDto paymentDto,Member member){
         paymentDto.setMemberStatus(member.getStatus());
        paymentDto.setLastName(member.getLastName());
        paymentDto.setFirstName(member.getFirstName());
        paymentDto.setEmail(member.getEmail());
        paymentDto.setTitle(member.getTitle());
        paymentDto.setMemberId(member.getId());




        return paymentDto;


    }



}

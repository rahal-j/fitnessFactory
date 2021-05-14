package com.school.school.dtoToEntityMapper;

import com.school.school.dto.PaymentDto;
import com.school.school.entity.Member;
import com.school.school.entity.Payment;
import com.school.school.entity.Subscription;

import java.util.Date;

public class PaymentDtoToEntityMapper {

    public static Payment getPaymentEntity(PaymentDto paymentDto, Payment payment, Member member){
        payment.setId(payment.getId() != null? payment.getId() : paymentDto.getId());
        payment.setDateCreated(new Date());
        payment.setMemberId(member);
        payment.setPaymentFromDate(paymentDto.getPaymentFromDate());
        payment.setPaymentToDate(paymentDto.getPaymentToDate());
        payment.setAmount(paymentDto.getAmount());
        payment.setStatus(paymentDto.getStatus());
        payment.setCreatedUser(paymentDto.getCreatedUser());
        payment.setExpireDate(paymentDto.getExpireDate());
        return payment;

    }



}

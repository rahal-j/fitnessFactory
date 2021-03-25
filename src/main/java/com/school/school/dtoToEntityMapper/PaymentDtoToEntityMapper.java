package com.school.school.dtoToEntityMapper;

import com.school.school.dto.PaymentDto;
import com.school.school.entity.Payment;
import com.school.school.entity.Subscription;

public class PaymentDtoToEntityMapper {

    public static Payment getPaymentEntity(PaymentDto paymentDto, Payment payment, Subscription subscription){
        payment.setId(payment.getId() != null? payment.getId() : paymentDto.getId());
        payment.setSubscriptionId(subscription);
        payment.setDateCreated(paymentDto.getDateCreated());
        payment.setUserId(paymentDto.getUserId());
        payment.setPaymentFromDate(paymentDto.getPaymentFromDate());
        payment.setPaymentToDate(paymentDto.getPaymentToDate());
        payment.setAmount(paymentDto.getAmount());
        payment.setStatus(paymentDto.getStatus());
        payment.setCreatedUser(paymentDto.getCreatedUser());
        return payment;

    }



}

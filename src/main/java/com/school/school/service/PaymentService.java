package com.school.school.service;

import com.school.school.dto.PaymentDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Payment;

import java.util.List;

public interface PaymentService {


    ResponseDto addPayment(PaymentDto paymentDto);

    List<Payment> fetchPayment();


    ResponseDto getPaymentDto(String nic);


}


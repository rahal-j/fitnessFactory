package com.school.school.service.impl;

import com.school.school.dto.PaymentDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dtoToEntityMapper.PaymentDtoToEntityMapper;
import com.school.school.entity.Member;
import com.school.school.entity.Payment;
import com.school.school.entity.Subscription;
import com.school.school.entityToDtoMapper.PaymentEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.repository.MemberDao;
import com.school.school.repository.PaymentDao;
import com.school.school.repository.SubscriptionDao;
import com.school.school.service.PaymentService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Override
    public ResponseDto addPayment(PaymentDto paymentDto){

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode() , "Transaction Fail");

        try{
            Subscription subscription = subscriptionDao.getOne(paymentDto.getSubscriptionId());

            Payment payment = PaymentDtoToEntityMapper.getPaymentEntity(paymentDto, new Payment(),subscription);
            paymentDao.save(payment);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Payment Save Successful");
            return responseDto;
        }catch (Exception e){

            return responseDto;

        }
    }






    @Override
    public List<Payment> fetchPayment(){return paymentDao.findAll();
    }



    @Override
    public ResponseDto getPaymentDto(String nic){

        Member member = null;
        ResponseDto responseDto = new ResponseDto();
        PaymentDto paymentDto = new PaymentDto();
         member = memberDao.findByNic(nic);
       paymentDto = PaymentEntityToDtoMapper.getPaymentDto(member);
         if (member != null){
             responseDto.setCode(ResponseEnum.SUCCESS.getCode());
             responseDto.setMessage("Please Proceed");
             responseDto.setData(paymentDto);
         }else {
             responseDto.setCode(ResponseEnum.FAIL.getCode());
             responseDto.setMessage("Please Do the Registration First");

         }
         return responseDto;
    }














    }


































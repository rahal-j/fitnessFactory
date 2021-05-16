package com.school.school.service.impl;

import com.school.school.dto.PaymentDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dtoToEntityMapper.PaymentDtoToEntityMapper;
import com.school.school.entity.Member;
import com.school.school.entity.Payment;
import com.school.school.entityToDtoMapper.PaymentEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.MemberDao;
import com.school.school.repository.PaymentDao;
import com.school.school.repository.SubscriptionDao;
import com.school.school.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Payment> payments = new ArrayList<>();
        paymentDto.setStatus(TransactionStatus.ACTIVE.getCode());


        try{

            Member member = memberDao.getOne(paymentDto.getMemberId());
            payments = paymentDao.findAllByMemberIdAndStatus(member,TransactionStatus.ACTIVE.getCode());
            Payment payment = PaymentDtoToEntityMapper.getPaymentEntity(paymentDto, new Payment(),member);




            if(payments.size() == 0 || payments.isEmpty()){
                paymentDao.save(payment);

            }else{
                for (Payment payment1 : payments){
                    payment1.setStatus(TransactionStatus.DEACTIVE.getCode());
                    paymentDao.save(payment1);
                }
                paymentDao.save(payment);


            }

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
         Payment payment = paymentDao.findByMemberIdAndStatus(member,TransactionStatus.ACTIVE.getCode());
         if(payment.getPaymentToDate() != null){
             paymentDto.setOldexpireDate(payment.getPaymentToDate().toString());

         }else{
             paymentDto.setOldexpireDate("N\\nA");

         }
       paymentDto = PaymentEntityToDtoMapper.getPaymentDto(paymentDto,member);
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



    @Override
    public List<Payment> fetchPaymentFromMember(String nic){
        Member member = memberDao.findByNic(nic);


        List<Payment> payments = paymentDao.findAllByMemberIdAndStatus(member,TransactionStatus.ACTIVE.getCode());

        return payments;


    }












    }


































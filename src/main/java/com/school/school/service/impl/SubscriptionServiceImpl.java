package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.dtoToEntityMapper.SubscriptionDtoToEntityMapper;
import com.school.school.entity.Subscription;
import com.school.school.entityToDtoMapper.SubscriptionEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.SubscriptionDao;
import com.school.school.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;



    @Override
    public ResponseDto addSubscription(SubscriptionDto subscriptionDto){

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode() , "Transaction Fail");

        try{
            Subscription subscription = SubscriptionDtoToEntityMapper.getSubscriptionEntity(subscriptionDto, new Subscription());
            subscriptionDao.save(subscription);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Subscription Save Successful");
            return responseDto;
        }catch (Exception e){

            return responseDto;

        }
    }

    @Override
    public List<SubscriptionDto> getActiveSubscriptionList(){
        List<SubscriptionDto> subscriptionDtos = new ArrayList<>();
        List<Subscription> subscriptions = subscriptionDao.findAllByStatus("ACTIVE");
        for(Subscription subscription : subscriptions){
           SubscriptionDto subscriptionDto = SubscriptionEntityToDtoMapper.getSubscriptionDto(new SubscriptionDto(),subscription);
           subscriptionDtos.add(subscriptionDto);
        }

        return subscriptionDtos;

    }


    @Override
    public List<Subscription> fetchSubscription(){return subscriptionDao.findAll();
    }





    @Override
    public ResponseDto activateSubscription(int id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Subscription subscription = subscriptionDao.getOne(id);
        if(subscription != null){
            subscription.setStatus(TransactionStatus.ACTIVE.getCode());
            subscriptionDao.save(subscription);
            return  new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Product Activate Successfully");

        }

        return responseDto;


    }


    @Override
    public ResponseDto deactivateSubscription(int id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Subscription subscription = subscriptionDao.getOne(id);
        if(subscription != null){
            subscription.setStatus(TransactionStatus.DEACTIVE.getCode());
            subscriptionDao.save(subscription);
            return  new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Product Deactivate Successfully");
        }

        return responseDto;

    }


    @Override
    public ResponseDto update(SubscriptionDto subscriptionDto){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Subscription subscription = subscriptionDao.findByName(subscriptionDto.getName());
        if(subscription != null){
            subscriptionDao.save(SubscriptionDtoToEntityMapper.getSubscriptionEntity(subscriptionDto,subscription));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Subscription updated successfully");

        }
        return responseDto;
    }

        @Override
        public ResponseDto getSubscriptionData(int id){

            return new ResponseDto(SubscriptionEntityToDtoMapper.getSubscriptionDto(new SubscriptionDto(),subscriptionDao.getOne(id)));
        }








}

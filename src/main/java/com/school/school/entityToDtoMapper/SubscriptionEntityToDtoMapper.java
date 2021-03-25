package com.school.school.entityToDtoMapper;

import com.school.school.dto.SubscriptionDto;
import com.school.school.entity.Subscription;


public class SubscriptionEntityToDtoMapper {

    public static SubscriptionDto getSubscriptionDto(SubscriptionDto subscriptionDto, Subscription subscription){
         subscriptionDto.setId(subscription.getId());
        subscriptionDto.setName(subscription.getName());
        subscriptionDto.setStatus(subscription.getStatus());
         return subscriptionDto;
    }

}

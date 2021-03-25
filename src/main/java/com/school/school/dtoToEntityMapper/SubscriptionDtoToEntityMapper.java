package com.school.school.dtoToEntityMapper;

import com.school.school.dto.SubscriptionDto;
import com.school.school.entity.Subscription;

public class SubscriptionDtoToEntityMapper {

    public static Subscription getSubscriptionEntity(SubscriptionDto subscriptionDto, Subscription subscription){

        subscription.setId(subscription.getId() != null? subscription.getId(): subscriptionDto.getId());
        subscription.setName(subscriptionDto.getName());
        subscription.setStatus(subscriptionDto.getStatus());
        return subscription;


    }


}

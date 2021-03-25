package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    ResponseDto addSubscription(SubscriptionDto subscriptionDto);

    List<SubscriptionDto> getActiveSubscriptionList();

    List<Subscription> fetchSubscription();

    ResponseDto activateSubscription(int id);

    ResponseDto deactivateSubscription(int id);

    ResponseDto update(SubscriptionDto subscriptionDto);

    ResponseDto getSubscriptionData(int id);
}

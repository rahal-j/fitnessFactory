package com.school.school.repository;

import com.school.school.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionDao extends JpaRepository<Subscription,Integer> {

   List<Subscription> findAllByStatus(String status);
   Subscription findByName (String name);

}

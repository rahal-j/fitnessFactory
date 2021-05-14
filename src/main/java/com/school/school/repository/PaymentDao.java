package com.school.school.repository;

import com.school.school.entity.Member;
import com.school.school.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PaymentDao extends JpaRepository<Payment,Integer> {

    List<Payment> findByMemberIdAndStatus(Member member, String status);







}

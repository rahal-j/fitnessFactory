package com.school.school.repository;

import com.school.school.entity.Member;
import com.school.school.entity.Schedule;
import com.school.school.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleDao extends JpaRepository<Schedule,Integer> {

    List<Schedule> findByMemberIdAndStatus(Member member, String status);

     @Query(value = "SELECT * FROM fitness_factory.schedule  where status='ACTIVE' group by schedule_id", nativeQuery = true)
    List<Schedule>findGroupByShedules();




}

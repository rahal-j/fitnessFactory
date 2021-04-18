package com.school.school.repository;

import com.school.school.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDao extends JpaRepository<Schedule,Integer> {
}

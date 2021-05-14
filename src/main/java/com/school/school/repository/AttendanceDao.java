package com.school.school.repository;

import com.school.school.entity.Attendance;
import com.school.school.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceDao extends JpaRepository<Attendance,Integer> {


    @Query(value = "SELECT * FROM attendance WHERE member=?1 ", nativeQuery = true)
    List<Attendance> findAttendanceByMemberId(int memberId);





}

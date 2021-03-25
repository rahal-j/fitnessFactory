package com.school.school.repository;

import com.school.school.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member,Integer> {

    Member findByNic(String nic);




}

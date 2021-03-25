package com.school.school.repository;

import com.school.school.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Subject findByName(final String name);

    Subject findByNameEqualsAndStatus(final String name,final String status);

    List<Subject> findAllByStatus(final String status);
}

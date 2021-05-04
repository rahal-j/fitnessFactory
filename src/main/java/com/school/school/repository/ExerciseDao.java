package com.school.school.repository;

import com.school.school.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseDao extends JpaRepository<Exercise,Integer> {
    Exercise findByName (String name);
    List<Exercise> findAllByStatus(String status);


}

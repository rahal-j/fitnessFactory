package com.school.school.service;

import com.school.school.dto.ExerciseDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Exercise;

import java.util.List;

public interface ExerciseServise {


    ResponseDto addExercise(ExerciseDto exerciseDto);

    List<Exercise> fetchExercise();

    ResponseDto deactivate(int id);

    ResponseDto activate(int id);

    ResponseDto getExerciseData(int id);

    ResponseDto update(ExerciseDto exerciseDto);
}

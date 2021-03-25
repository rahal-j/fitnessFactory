package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    ResponseDto saveSubject(SubjectDto subjectDto);

    ResponseDto deleteSubject(long id);

    ResponseDto updateSubject(SubjectDto subjectDto);

    ResponseDto fetchAll();

    ResponseDto deactivateSubject(long id);

    ResponseDto activateSubject(long id);

    List<SubjectDto> getActiveSubjectList();

    ResponseDto getSubjectData(long id);
}

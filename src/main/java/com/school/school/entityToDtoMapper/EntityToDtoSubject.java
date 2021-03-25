package com.school.school.entityToDtoMapper;

import com.school.school.dto.SubjectDto;
import com.school.school.entity.Subject;
import com.school.school.enums.TransactionStatus;

public class EntityToDtoSubject {


    public static SubjectDto getSubjectDto(SubjectDto subjectDto, Subject subject){
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setStatus(TransactionStatus.valueOf(subject.getStatus()).getCode());
        return subjectDto;
    }
}

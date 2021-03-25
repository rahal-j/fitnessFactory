package com.school.school.dtoToEntityMapper;

import com.school.school.dto.SubjectDto;
import com.school.school.entity.Subject;
import com.school.school.enums.TransactionStatus;

public class DtoToEntitySubject {


    public static Subject getSubject(Subject subject, SubjectDto subjectDto){
        subject.setId(subjectDto.getId()!= null ? subjectDto.getId():null);
        subject.setName(subjectDto.getName());
        subject.setStatus(TransactionStatus.valueOf(subjectDto.getStatus()).getCode());
        return subject;
    }
}

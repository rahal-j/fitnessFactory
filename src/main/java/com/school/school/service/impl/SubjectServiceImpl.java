package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubjectDto;
import com.school.school.dtoToEntityMapper.DtoToEntityMapperClass;
import com.school.school.dtoToEntityMapper.DtoToEntitySubject;
import com.school.school.entity.Room;
import com.school.school.entity.Subject;
import com.school.school.entityToDtoMapper.EntityToDtoSubject;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.SubjectRepository;
import com.school.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public ResponseDto saveSubject(SubjectDto subjectDto){

         try {
            subjectRepository.save(DtoToEntitySubject.getSubject(new Subject(),subjectDto));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Subject Succesfully Updated !");
        }catch (Exception e){
            return new ResponseDto(ResponseEnum.FAIL.getCode(),"Subject Already Exist !");
        }

     }

    @Override
    public ResponseDto deleteSubject(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Subject subject = subjectRepository.getOne(id);
        if(subject != null) {
            subject.setStatus(TransactionStatus.DEACTIVE.getCode());
            subjectRepository.save(subject);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Subject deleted successfully");
        }
        return responseDto;
    }

    @Override
    public ResponseDto updateSubject(SubjectDto subjectDto){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Subject subject = subjectRepository.findByName(subjectDto.getName());
        if(subject != null){
            subjectRepository.save(DtoToEntitySubject.getSubject(subject,subjectDto));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Subject updated successfully");

        }
        return responseDto;
    }


    @Override
    public ResponseDto deactivateSubject(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Subject subject = subjectRepository.getOne(id);
        if(subject != null) {
            subject.setStatus(TransactionStatus.DEACTIVE.getCode());
            subjectRepository.save(subject);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Subject deactivated successfully");
        }
        return responseDto;
    }

    @Override
    public ResponseDto activateSubject(final long id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Subject subject = subjectRepository.getOne(id);
        if(subject != null) {
            subject.setStatus(TransactionStatus.ACTIVE.getCode());
            subjectRepository.save(subject);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Class room activated successfully");
        }
        return responseDto;


    }

    @Override
    public ResponseDto fetchAll(){
        return new ResponseDto(subjectRepository.findAll());
    }

    @Override
    public List<SubjectDto> getActiveSubjectList(){
      return   subjectRepository.findAllByStatus(TransactionStatus.ACTIVE.getCode()).stream().map(t ->
              EntityToDtoSubject.getSubjectDto(new SubjectDto(),t)).collect(Collectors.toList());
    }


    @Override
    public ResponseDto getSubjectData(final long id){

        return new ResponseDto(EntityToDtoSubject.getSubjectDto(new SubjectDto(),subjectRepository.getOne(id)));
    }



}

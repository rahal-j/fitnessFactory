package com.school.school.service.impl;


import com.school.school.dto.MemberDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dtoToEntityMapper.MemberDtoToEntityMapper;
import com.school.school.entity.Member;
import com.school.school.entity.Subscription;
import com.school.school.entity.UserRole;
import com.school.school.entityToDtoMapper.MemberEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.enums.UserRolesEnum;
import com.school.school.repository.MemberDao;
import com.school.school.repository.SubscriptionDao;
import com.school.school.repository.UserRoleDao;
import com.school.school.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private SubscriptionDao subscriptionDao;/**/

    @Autowired
    private UserRoleDao userRoleDao;


    @Override
    public ResponseDto addMember(MemberDto memberDto){

        ResponseDto responseDto =new ResponseDto(ResponseEnum.FAIL.getCode(),"Transaction Failed");
        try {
            UserRole userRole = userRoleDao.findByName(UserRolesEnum.MEMBER.getCode());
/*
            Subscription subscription = subscriptionDao.getOne(memberDto.getSubscription());
*/
            Member member = MemberDtoToEntityMapper.getMemberEntity(memberDto, new Member());
              memberDao.save(member);
              responseDto.setCode(ResponseEnum.SUCCESS.getCode());
              responseDto.setMessage("Member Save Successful");
        return responseDto;

        }catch (Exception e){
            return responseDto;
        }






    }


    @Override
    public List<Member> fetchMember(){return memberDao.findAll();}

    @Override
    public ResponseDto deactivate(int id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Member member = memberDao.getOne(id);
        if(member != null) {
            member.setStatus(TransactionStatus.DEACTIVE.getCode());
            memberDao.save(member);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Member deactivated successfully");
        }
        return responseDto;
    }

    @Override
    public ResponseDto activate(int id){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Member member = memberDao.getOne(id);
        if (member!= null){
            member.setStatus(TransactionStatus.ACTIVE.getCode());
            memberDao.save(member);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Member Activated Successfully");

        }
        return responseDto;
    }


    @Override
    public ResponseDto getMemberData(int id){

        Member member = new Member();
        member = memberDao.getOne(id);
/*
        Subscription subscription = new Subscription();
        subscription = subscriptionDao.getOne(id);*/




        return new ResponseDto(MemberEntityToDtoMapper.getMemberDto(new MemberDto(),member));
    }





}

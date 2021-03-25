package com.school.school.service;

import com.school.school.dto.MemberDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Member;

import java.util.List;

public interface MemberService {

    ResponseDto addMember(MemberDto memberDto);

    List<Member> fetchMember();

    ResponseDto deactivate(int id);

    ResponseDto activate(int id);

    ResponseDto getMemberData(int id);
}

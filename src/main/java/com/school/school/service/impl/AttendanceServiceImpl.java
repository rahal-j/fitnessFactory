package com.school.school.service.impl;

import com.school.school.dto.AttendanceDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dtoToEntityMapper.AttendanceDtoToEntityMapper;
import com.school.school.entity.Attendance;
import com.school.school.entity.Member;
import com.school.school.entity.Payment;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.AttendanceDao;
import com.school.school.repository.MemberDao;
import com.school.school.repository.PaymentDao;
import com.school.school.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PaymentDao paymentDao;


    @Override
    public ResponseDto addAttendance(AttendanceDto attendanceDto){


        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),"Transaction Fail");

        try{

            Member member = memberDao.getOne(attendanceDto.getMemberId());

            Attendance attendance = AttendanceDtoToEntityMapper.getAttendanceEntity(attendanceDto, new Attendance(),member);
            attendanceDao.save(attendance);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Attendance Marked");
            return responseDto;


        }catch (Exception e){
            return responseDto;
        }

    }


    @Override
    public List<Attendance> fetchAttendance(){return attendanceDao.findAll();}



    @Override
    public ResponseDto getAttendanceDto(String nic){
        Member member = null;
        ResponseDto responseDto = new ResponseDto();
        AttendanceDto attendanceDto = new AttendanceDto();
        member = memberDao.findByNic(nic);
        // save attendance
        Attendance attendance = new Attendance();
        attendance.setMemberId(member);
        attendance.setDate(new Date());

        attendanceDao.save(attendance);

        // check payment status
        Payment payment = paymentDao.findAllByMemberIdAndStatus(member,TransactionStatus.ACTIVE.getCode()).get(0);

        return compareDates(payment);

    }

    private ResponseDto compareDates(Payment payment){

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),"Transaction Fail");
        String msg ="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            Date date = new Date();
            date1 = sdf.parse(String.valueOf(sdf.format(date)));
             date2 = sdf.parse(String.valueOf(payment.getPaymentToDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int result = date1.compareTo(date2);
        System.out.println("result: " + result);

        if (result == 0) {
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Your MemberShip Expires Tomorrow");

        } else if (result > 0) {

            responseDto.setCode(ResponseEnum.FAIL.getCode());
            responseDto.setMessage("Your MemberShip has already expired on :"+date2);


        } else if (result < 0) {

            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Your Payment Due date is  :"+date2);

         } else {
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Welcome to Gym");
        }
        return responseDto;
    }


    @Override
    public List<Attendance> getMemberAttendance(int memberId){

      return attendanceDao.findAttendanceByMemberId(memberId);

    }



}

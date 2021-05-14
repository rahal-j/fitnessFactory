package com.school.school.controller;


import com.school.school.dto.AttendanceDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Member;
import com.school.school.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("attendance")
@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/")
    public String addAttendance(Model model){
        model.addAttribute("attendance", attendanceService.fetchAttendance());
        return "attendance_list";
    }


    @GetMapping("/insertPage")
    public String getInsertPage(){
        return "attendance";
    }


    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveAttendance(@RequestBody AttendanceDto attendanceDto){
        return attendanceService.addAttendance(attendanceDto);
    }

    @GetMapping("/memberAttendance")
    @ResponseBody
    public ResponseDto getPaymentDto(@RequestParam String nic){

        return attendanceService.getAttendanceDto(nic);

    }

    @GetMapping("/attendanceList")
    @ResponseBody
    public ResponseDto getAttendanceList(int memberId){
         ResponseDto responseDto = new ResponseDto();
        responseDto.setData(attendanceService.getMemberAttendance(memberId));
        return responseDto;



    }


}

package com.school.school.dto;

import java.io.Serializable;
import java.util.Date;

public class AttendanceDto implements Serializable {

    private Integer id;
    private Date date;
    private Integer memberId;


    public AttendanceDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}

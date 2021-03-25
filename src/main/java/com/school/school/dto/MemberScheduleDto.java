package com.school.school.dto;

import java.util.Date;

public class MemberScheduleDto {
    private Integer id;
    private Integer memberId;
    private Integer exerciseId;
    private Integer scheduleId;
    private String status;
    private Integer noOfSets;
    private Integer noOfReps;
    private Date dateCreated;

    public MemberScheduleDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNoOfSets() {
        return noOfSets;
    }

    public void setNoOfSets(Integer noOfSets) {
        this.noOfSets = noOfSets;
    }

    public Integer getNoOfReps() {
        return noOfReps;
    }

    public void setNoOfReps(Integer noOfReps) {
        this.noOfReps = noOfReps;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}

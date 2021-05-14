package com.school.school.dto;

import java.util.List;

public class ScheduleExerciseDto {

    private List<String> exercises;
    private List<String> setsList;
    private List<String> repsList;
    private String memberId;
    private Integer scheduleId;
    private String scheduleName;


    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
    }

    public List<String> getSetsList() {
        return setsList;
    }

    public void setSetsList(List<String> setsList) {
        this.setsList = setsList;
    }

    public List<String> getRepsList() {
        return repsList;
    }

    public void setRepsList(List<String> repsList) {
        this.repsList = repsList;
    }


}

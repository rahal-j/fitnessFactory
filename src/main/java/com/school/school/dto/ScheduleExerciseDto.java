package com.school.school.dto;

import java.util.List;

public class ScheduleExerciseDto {

    private List<String> exercises;
    private List<String> setsLIst;
    private List<String> repsList;
    private List<String> scheduleNos;

    public List<String> getExercises() {
        return exercises;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
    }

    public List<String> getSetsLIst() {
        return setsLIst;
    }

    public void setSetsLIst(List<String> setsLIst) {
        this.setsLIst = setsLIst;
    }

    public List<String> getRepsList() {
        return repsList;
    }

    public void setRepsList(List<String> repsList) {
        this.repsList = repsList;
    }

    public List<String> getScheduleNos() {
        return scheduleNos;
    }

    public void setScheduleNos(List<String> scheduleNos) {
        this.scheduleNos = scheduleNos;
    }
}

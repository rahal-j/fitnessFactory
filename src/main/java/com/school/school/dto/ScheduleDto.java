package com.school.school.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ScheduleDto implements Serializable {

    private Integer id;
    private String name;
    private Integer exerciseId;
    private Integer memberID;
    private Date date;
    private int sets;
    private int reps;
    private String memberStatus;
    private String firstName;
    private String lastName;
    private String Title;
    private String email;
    private Integer scheduleNo;


    private List<String> exercises;
    private List<String> setsLIst;
    private List<String> repsList;
    private List<String> scheduleNos;




    public ScheduleDto() {
    }

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

    public Integer getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(Integer scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}

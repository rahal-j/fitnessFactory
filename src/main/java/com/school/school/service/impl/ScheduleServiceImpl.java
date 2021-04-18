package com.school.school.service.impl;

import com.school.school.repository.ExerciseDao;
import com.school.school.repository.MemberDao;
import com.school.school.repository.ScheduleDao;
import com.school.school.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

public class ScheduleServiceImpl implements ScheduleService {


    @Autowired
    private ScheduleDao scheduleDao;


    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private MemberDao memberDao;

























}

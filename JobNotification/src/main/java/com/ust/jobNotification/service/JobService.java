package com.ust.jobNotification.service;

import com.ust.jobNotification.model.Jobinfo;
import com.ust.jobNotification.repo.Jobrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private Jobrepo repo;
    public Jobinfo addjob(Jobinfo info){
        return repo.save(info);
    }

    public List<Jobinfo> getjob(){
        return repo.findAll();
    }
    public Jobinfo getjobbyid(int id){
        return repo.findById(id).orElse(null);
    }
}

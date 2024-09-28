package com.ust.jobNotification.controller;

import com.ust.jobNotification.model.Jobinfo;
import com.ust.jobNotification.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ust")
public class JobController {
    @Autowired
    private JobService service;

    @PostMapping("/addjob")
    public Jobinfo addjob(@RequestBody Jobinfo jobinfo){
        return service.addjob(jobinfo);
    }
    @GetMapping("/getjob")
    public List<Jobinfo> getjob(){
        return service.getjob();
    }
    @GetMapping("/getjob/{id}")
    public Jobinfo getjobbyid(@PathVariable int id){
        return service.getjobbyid(id);
    }
}

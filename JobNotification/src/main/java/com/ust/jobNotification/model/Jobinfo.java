package com.ust.jobNotification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jobinfo {
    //Define a simple model with attributes like jobId, jobTitle, description, location, and salary.
    @Id
    private int jobid;
    private String jobTitle;
    private String description;
    private String location;
    private int salary;
}

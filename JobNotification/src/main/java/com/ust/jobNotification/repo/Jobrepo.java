package com.ust.jobNotification.repo;

import com.ust.jobNotification.model.Jobinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Jobrepo extends JpaRepository<Jobinfo,Integer> {
}

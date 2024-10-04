package com.ust.laptop.repo;

import com.ust.laptop.model.Laptopinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface Laptoprepo extends JpaRepository<Laptopinfo,UUID> {
}

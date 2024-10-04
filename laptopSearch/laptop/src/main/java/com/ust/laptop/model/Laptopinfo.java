package com.ust.laptop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptopinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String brand;
    private double price;
    private String processor;
    private int storage;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createDate;
}

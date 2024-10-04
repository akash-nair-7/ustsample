package com.ust.laptop.controller;

import com.ust.laptop.model.Laptopinfo;
import com.ust.laptop.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/ust/laptops")
public class LaptopController {
    @Autowired
    private LaptopService service;

    // Add a new laptop
    @PostMapping("/add")
    public Laptopinfo addLaptop(@RequestBody Laptopinfo laptopinfo){
        return service.addlaptop(laptopinfo);
    }

    // Get all laptops
    @GetMapping("/all")
    public List<Laptopinfo> getAllLaptops(){
        return service.getlaptop();
    }

    // Search laptops by price range
    @GetMapping("/price")
    public List<Laptopinfo> getLaptopsByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return service.findByPrice(minPrice, maxPrice);
    }

    // Search laptops by brand
    @GetMapping("/brand")
    public List<Laptopinfo> getLaptopsByBrand(@RequestParam String brand) {
        return service.findByBrand(brand);
    }

    // Search laptops by processor
    @GetMapping("/processor")
    public List<Laptopinfo> getLaptopsByProcessor(@RequestParam String processor) {
        return service.findByProcessor(processor);
    }

    // Search laptops by storage capacity
    @GetMapping("/storage")
    public List<Laptopinfo> getLaptopsByStorage(@RequestParam int storage) {
        return service.findByStorage(storage);
    }
}

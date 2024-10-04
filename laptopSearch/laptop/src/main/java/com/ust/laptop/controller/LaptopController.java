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

    
    @PostMapping("/add")
    public Laptopinfo addLaptop(@RequestBody Laptopinfo laptopinfo){
        return service.addlaptop(laptopinfo);
    }

    
    @GetMapping("/all")
    public List<Laptopinfo> getAllLaptops(){
        return service.getlaptop();
    }

    
    @GetMapping("/price")
    public List<Laptopinfo> getLaptopsByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return service.findByPrice(minPrice, maxPrice);
    }

    
    @GetMapping("/brand")
    public List<Laptopinfo> getLaptopsByBrand(@RequestParam String brand) {
        return service.findByBrand(brand);
    }

    
    @GetMapping("/processor")
    public List<Laptopinfo> getLaptopsByProcessor(@RequestParam String processor) {
        return service.findByProcessor(processor);
    }

    
    @GetMapping("/storage")
    public List<Laptopinfo> getLaptopsByStorage(@RequestParam int storage) {
        return service.findByStorage(storage);
    }
}

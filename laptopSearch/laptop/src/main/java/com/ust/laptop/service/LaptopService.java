package com.ust.laptop.service;

import com.ust.laptop.exception.LaptopNotFoundException;
import com.ust.laptop.model.Laptopinfo;
import com.ust.laptop.repo.Laptoprepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LaptopService {

    @Autowired
    private Laptoprepo repo;

    // Add a new laptop to the database
    public Laptopinfo addlaptop(Laptopinfo laptopinfo) {
        return repo.save(laptopinfo);
    }

    // Get all laptops
    public List<Laptopinfo> getlaptop() {
        return repo.findAll();
    }

    // Search laptops by price range
    public List<Laptopinfo> findByPrice(double minPrice, double maxPrice) {
        return repo.findAll().stream()
                .filter(laptop -> laptop.getPrice() >= minPrice && laptop.getPrice() <= maxPrice)
                .toList();
    }

    // Search laptops by brand
    public List<Laptopinfo> findByBrand(String brand) {
        return repo.findAll().stream()
                .filter(laptop -> laptop.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    // Search laptops by processor
    public List<Laptopinfo> findByProcessor(String processor) {
        return repo.findAll().stream()
                .filter(laptop -> laptop.getProcessor().equalsIgnoreCase(processor))
                .toList();
    }

    // Search laptops by storage capacity
    public List<Laptopinfo> findByStorage(int storage) {
        return repo.findAll().stream()
                .filter(laptop -> laptop.getStorage() == storage)
                .toList();
    }

    // Get laptop by UUID
    public Laptopinfo getLaptop(UUID id) throws LaptopNotFoundException {
        return repo.findById(id)
                .orElseThrow(() -> new LaptopNotFoundException("Laptop not found with id: " + id));
    }
}

package ust.carSearch.controller;

import org.springframework.web.bind.annotation.*;
import ust.carSearch.dto.CarDto;
import ust.carSearch.model.Car;
import ust.carSearch.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class Carcontroller {
    @Autowired
    private CarService carService;

    @GetMapping("/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        List<Car> availableCars = carService.findAvailableCars();
        return ResponseEntity.ok(availableCars);
    }
    @GetMapping("/modelname")
    public ResponseEntity<List<Car>> getCarsByModelName(@PathVariable String modelname) {
        List<Car> cars = carService.findCarsByModelName(modelname);
        return ResponseEntity.ok(cars);
    }
    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody CarDto carDto) {
        Car savedCarDto = carService.saveCar(carDto);
        return ResponseEntity.ok(savedCarDto);
    }
    @GetMapping("/models/{brand}")
    public ResponseEntity<List<String>> getModelsByBrand(@PathVariable String brand) {
        List<String> models = carService.findModelsByBrand(brand);
        return ResponseEntity.ok(models);
    }




}
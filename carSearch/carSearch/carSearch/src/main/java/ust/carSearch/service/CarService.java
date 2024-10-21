package ust.carSearch.service;


import ust.carSearch.dto.CarDto;
import ust.carSearch.model.Car;
import ust.carSearch.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;


    public List<Car> findAvailableCars() {
        return carRepository.findByAvailable(true);
    }
    public List<Car> findCarsByModelName(String modelname) {
        return carRepository.findByModelname(modelname);
    }
    public Car saveCar(CarDto carDto) {
        // Convert CarDto to Car
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModelname(carDto.getModelName());
        car.setAvailable(true); // Or set it based on your logic

        return carRepository.save(car);
    }
    public List<String> findModelsByBrand(String brand) {
        List<Car> cars = carRepository.findByBrand(brand);
        return cars.stream().map(Car::getModelname).distinct().collect(Collectors.toList());
    }


}
package ust.carSearch.repository;

import ust.carSearch.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByAvailable(boolean b);
    List<Car> findByModelname(String modelname);
    List<Car> findByBrand(String brand);

}


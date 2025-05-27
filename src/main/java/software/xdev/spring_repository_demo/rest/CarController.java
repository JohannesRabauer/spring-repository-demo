package software.xdev.spring_repository_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.xdev.spring_repository_demo.db.cars.Car;
import software.xdev.spring_repository_demo.db.cars.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping("/new")
    Car newCar(@RequestBody Car newCar) {
        return carRepository.save(newCar);
    }
}
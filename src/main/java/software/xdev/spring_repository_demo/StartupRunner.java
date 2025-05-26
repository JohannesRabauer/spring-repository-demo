package software.xdev.spring_repository_demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.xdev.spring_repository_demo.db.cars.Car;
import software.xdev.spring_repository_demo.db.cars.CarRepository;
import software.xdev.spring_repository_demo.db.sales.Sale;
import software.xdev.spring_repository_demo.db.sales.SaleRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class StartupRunner {

    private final CarRepository carRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public StartupRunner(CarRepository carRepository, SaleRepository saleRepository) {
        this.carRepository = carRepository;
        this.saleRepository = saleRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Car amount after startup: " + this.carRepository.count());
        this.carRepository.findAll().forEach(car -> System.out.println("Car: " + car));
        System.out.println("Sale amount after startup: " + this.saleRepository.count());
        this.saleRepository.findAll().forEach(sale -> System.out.println("Sale: " + sale));

        Car newCar = new Car("BMW", "X1", 2024);
        carRepository.save(newCar);
        saleRepository.save(new Sale(newCar, BigDecimal.valueOf(32_000), LocalDateTime.now()));

        System.out.println("Car amount after update: " + this.carRepository.count());
        this.carRepository.findAll().forEach(car -> System.out.println("Car: " + car));
        System.out.println("Sale amount after update: " + this.saleRepository.count());
        this.saleRepository.findAll().forEach(sale -> System.out.println("Sale: " + sale));
    }
}

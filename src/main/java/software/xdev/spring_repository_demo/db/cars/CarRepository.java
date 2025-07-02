package software.xdev.spring_repository_demo.db.cars;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

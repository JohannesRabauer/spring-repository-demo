package software.xdev.spring_repository_demo.db.sales;

import jakarta.persistence.*;
import software.xdev.spring_repository_demo.db.cars.Car;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Car soldCar;

    private BigDecimal price;

    private LocalDateTime timestamp;

    public Sale() {
    }

    public Sale(Car soldCar, BigDecimal price, LocalDateTime timestamp) {
        this.soldCar = soldCar;
        this.price = price;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getSoldCar() {
        return soldCar;
    }

    public void setSoldCar(Car soldCar) {
        this.soldCar = soldCar;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", soldCar=" + soldCar +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}

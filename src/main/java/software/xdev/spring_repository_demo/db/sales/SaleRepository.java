package software.xdev.spring_repository_demo.db.sales;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByTimestampAfter(LocalDateTime timestampAfter);
}

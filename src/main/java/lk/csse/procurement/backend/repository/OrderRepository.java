package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

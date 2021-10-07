package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.DeliveryAdvice;
import lk.csse.procurement.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAdviceRepository extends JpaRepository<DeliveryAdvice, Long> {
}

package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}

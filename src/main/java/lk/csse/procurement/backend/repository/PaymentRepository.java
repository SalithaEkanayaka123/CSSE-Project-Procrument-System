package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.Payment;
import lk.csse.procurement.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}

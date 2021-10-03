package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcumentRepository {

    public Order addOrder(Order order);
    public Order getAllOrderDetails(Order order);

}

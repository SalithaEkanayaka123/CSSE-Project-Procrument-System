package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

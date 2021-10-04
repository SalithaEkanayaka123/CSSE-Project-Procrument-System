package lk.csse.procurement.backend.repository.impl;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProcumentRepositoryImplTest {

    @Autowired
    ProcumentRepository procumentRepository;

    @Test
    public void TestingInsertOrderItems(){
        Item item = new Item();
        item.setItemId(4);
        procumentRepository.insertOrderItems(1, item);
    }

}
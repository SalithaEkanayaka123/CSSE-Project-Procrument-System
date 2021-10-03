package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServicesTest {

    @Autowired
    OrderServices orderServices;

    @Test
    public void TestingTest() {
        orderServices.test();
    }

}
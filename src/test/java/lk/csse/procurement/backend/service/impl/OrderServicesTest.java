package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServicesTest {

    @Autowired
    OrderServices orderServices;

    @Test
    public void TestingTest() {
        orderServices.test();
    }

}
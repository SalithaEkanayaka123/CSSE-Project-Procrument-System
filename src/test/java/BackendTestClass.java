import lk.csse.procurement.backend.service.impl.OrderServices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
class BackendCiConfigTest extends Initializer {


    private OrderServices orderService;

    public BackendCiConfigTest(OrderServices orderService) {
        this.orderService = orderService;
    }




    @Test
    public void testingMethod() throws Exception {
        orderService.test();
    }
}

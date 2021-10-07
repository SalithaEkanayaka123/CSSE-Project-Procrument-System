package lk.csse.procurement.backend.controller;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import lk.csse.procurement.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProcumentRepository procumentRepository;

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        try {
            orderService.AddOrder(order);//must be changed
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getOrders(){
        //List<Class> classes = classRepository.findAll();
        List<Order> orders = orderRepository.findAll();
        if(orders.size() > 0){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No orders Available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ordersforsuppliers/{id}")
    public ResponseEntity<?> getOrdersForSupplier(@PathVariable("id") String id){
        //List<Class> classes = classRepository.findAll();
        List<Order> orders = procumentRepository.getOrdersForSupplier(id);
        if(orders.size() > 0){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No orders Available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteorder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") String id){
        procumentRepository.deleteOrder(id);
        procumentRepository.cleanUPOrderItemTable(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }


    @GetMapping("/getorderitemlist/{id}")
    public ResponseEntity<?> getOrderItemList(@PathVariable("id") String id){
        //List<Class> classes = classRepository.findAll();
        List<Item> orders = orderService.getOrderItemList(id);
        if(orders.size() > 0){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No items Available", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/ordermanagerapproval/{id}")
    public ResponseEntity<?> orderManagerApproval(@PathVariable("id") String id, @RequestBody Order order){
        //List<Class> classes = classRepository.findAll();
        int status = orderService.orderManagerApproval(id, order.getStatus());
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

    @GetMapping("/calculatetotalcost/{id}")
    public ResponseEntity<?> calculateTotalCostForOrder(@PathVariable("id") String id){
        //List<Class> classes = classRepository.findAll();
        Double totalCostForOrder = orderService.calculateTotalCostForOrder(id);
        if(totalCostForOrder > 0){
            return new ResponseEntity<>(totalCostForOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") String id, @RequestBody Order order){
        //List<Class> classes = classRepository.findAll();
        orderService.updateOder(order, id);
        return new ResponseEntity<>("sucessfully update order", HttpStatus.OK);

    }

    //calculateTotalCostForSupplier
    @GetMapping("/calculatetotalcostforsupplier")
    public ResponseEntity<?> calculateTotalCostForSupplier(@RequestBody Order order){
        //List<Class> classes = classRepository.findAll();
        Double totalCostForOrder = orderService.calculateTotalCostForSupplier(order.getSupplierId());
        if(totalCostForOrder > 0){
            return new ResponseEntity<>(totalCostForOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/paymentProcess/{id}")
    public ResponseEntity<?> processPayment(@PathVariable("id") String id){
        //List<Class> classes = classRepository.findAll();
        String result = orderService.processPayment(id);
            return new ResponseEntity<>(result, HttpStatus.OK);

    }


}

package lk.csse.procurement.backend.controller;

import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.ProcumentRepository;
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

    @PostMapping("/order")
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        try {
            orderRepository.save(order);
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

    @DeleteMapping("/deleteorder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") long id){
        orderRepository.deleteById(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }
}

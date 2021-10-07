package lk.csse.procurement.backend.controller;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.model.Supplier;
import lk.csse.procurement.backend.model.User;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import lk.csse.procurement.backend.repository.UserRepository;
import lk.csse.procurement.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userController;

    @Autowired
    ProcumentRepository procumentRepository;

    @Autowired
    OrderService orderService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {
            userController.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody User user){
        //List<Class> classes = classRepository.findAll();
        User us = orderService.updateUser(user, id);
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @PutMapping("/updateSupplier/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable("id") String id, @RequestBody Supplier user){
        //List<Class> classes = classRepository.findAll();
        User us = orderService.updateUser(user, id);
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @GetMapping ("/users")
    public ResponseEntity<?> getUsers(){
        List<User> user =  userController.findAll();
        if(user.size() > 0){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No users Available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/sitemanagers")
    public ResponseEntity<?> getAllSiteManagers(){
        List<User> user =  procumentRepository.getAllSiteManagers();
        if(user.size() > 0){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No users Available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
        procumentRepository.deleteUser(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }

    @GetMapping("/availsupplier")
    public ResponseEntity<?> getAvailableSuppliers(){
        //working
        //userController.deleteById(id);
        List<Supplier> user =  procumentRepository.getAllAvailableSuppliers();
        if(user.size() > 0){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No users Available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getsupplierbyorder/{id}")
    public ResponseEntity<?> getSuppliersByOrder(@PathVariable("id") String id){
        //working
        //userController.deleteById(id);
        List<Supplier> user =  orderService.getSuppliersByOrder(id);
        if(user.size() > 0){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No users Available", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getsupplierItemList/{id}")
    public ResponseEntity<?> getSupplierItemList(@PathVariable("id") String id){
        //working
        //userController.deleteById(id);
        List<Item> user =  orderService.getOrderItemListBySupplierID(id);
        if(user.size() > 0){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No users Available", HttpStatus.NOT_FOUND);
        }
    }


}

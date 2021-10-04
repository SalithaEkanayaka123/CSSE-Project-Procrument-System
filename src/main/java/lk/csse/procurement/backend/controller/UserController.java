package lk.csse.procurement.backend.controller;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.model.User;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.UserRepository;
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

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {
            userController.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        userController.deleteById(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }
}

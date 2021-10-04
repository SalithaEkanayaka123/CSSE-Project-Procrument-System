package lk.csse.procurement.backend.controller;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.repository.ItemRepository;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/item")
    public ResponseEntity<?> addItems(@RequestBody Item item){
        try {
            itemRepository.save(item);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items")
    public ResponseEntity<?> getItems(){
        //List<Class> classes = classRepository.findAll();
        List<Item> items = itemRepository.findAll();
        if(items.size() > 0){
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No orders Available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteitems/{id}")
    public ResponseEntity<?> deleteItems(@PathVariable("id") long id){
        itemRepository.deleteById(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }
}

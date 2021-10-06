package lk.csse.procurement.backend.controller;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.repository.ItemRepository;
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
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProcumentRepository procumentRepository;

    @Autowired
    OrderService orderService;


    @PostMapping("/item")
    public ResponseEntity<?> addItems(@RequestBody Item item) {
        try {
            itemRepository.save(item);
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items")
    public ResponseEntity<?> getItems() {
        //List<Class> classes = classRepository.findAll();
        List<Item> items = itemRepository.findAll();
        if (items.size() > 0) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No orders Available", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteitems/{id}")
    public ResponseEntity<?> deleteItems(@PathVariable("id") String id) {
        int result  = procumentRepository.deleteItem(Integer.parseInt(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/updateitems/{id}")
    public ResponseEntity<?> updateItems(@PathVariable("id") String id, @RequestBody Item item) {
        Item result = orderService.updateItem(item, Integer.parseInt(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getitemlistbyid/{id}")
    public ResponseEntity<?> getItemListByItemID(@PathVariable("id") int id) {
        try {
            List<Item> itemList = orderService.getItemListByItemID(id);
            return new ResponseEntity<>(itemList, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOrderitemlistBystatus")
    public ResponseEntity<?> getOrderItemListByStatus(@RequestBody Order order) {
        try {
            System.out.println("valus " + order.getStatus() + " dd " + order.getSupplierId());
            List<Item> itemList = orderService.getOrderItemListByStatus(order.getStatus(), order.getSupplierId());
            return new ResponseEntity<>(itemList, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getadviceNoticeItemList")
    public ResponseEntity<?> getAdviceNoticeItemList(@RequestBody Order order) {
        try {
            List<Item> itemList = orderService.getAdviceNoticeItemList(order.getOrderId());
            return new ResponseEntity<>(itemList, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}

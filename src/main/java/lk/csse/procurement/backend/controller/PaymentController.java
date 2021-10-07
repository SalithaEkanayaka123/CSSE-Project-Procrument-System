package lk.csse.procurement.backend.controller;

import lk.csse.procurement.backend.model.Card;
import lk.csse.procurement.backend.model.Cash;
import lk.csse.procurement.backend.model.Check;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;


    @PostMapping("/paymentCard")
    public ResponseEntity<?> cardPayment(@RequestBody Card card){
        try {
            paymentRepository.save(card);//must be changed
            return new ResponseEntity<Card>(card, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/paymentCash")
    public ResponseEntity<?> cashPayment(@RequestBody Cash cash){
        try {
            paymentRepository.save(cash);//must be changed
            return new ResponseEntity<Cash>(cash, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/paymentCheque")
    public ResponseEntity<?> ChequePayment(@RequestBody Check check){
        try {
            paymentRepository.save(check);//must be changed
            return new ResponseEntity<Check>(check, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/getPayment")
    public ResponseEntity<?> getPayment(@RequestBody Check check){
        try {
            paymentRepository.save(check);//must be changed
            return new ResponseEntity<Check>(check, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}

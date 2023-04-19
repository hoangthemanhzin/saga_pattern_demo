package com.example.paymentservice.Controller;

import com.example.paymentservice.Model.OrderModel;
import com.example.paymentservice.Model.PaymentModel;
import com.example.paymentservice.Repository.PaymentRepository;
import com.example.paymentservice.Service.PaymentService;
import com.example.paymentservice.routing.OrderServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    @Autowired
    private OrderServiceClient orderServiceClient;

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return orderServiceClient.hello();
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello1(){
        return "loaloaloa";
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addPayment(@RequestBody PaymentModel paymentModel){
        paymentRepository.save(paymentModel);
        return "thanh cong";
    }

    @PostMapping("/statusOrder_Payment")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderModel> statusOrder_Payment(@RequestBody OrderModel orderModel){
        return ResponseEntity.ok(paymentService.statusOrder_Payment(orderModel));
    }
}

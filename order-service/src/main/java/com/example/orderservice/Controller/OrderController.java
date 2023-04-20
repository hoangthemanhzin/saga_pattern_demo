package com.example.orderservice.Controller;

import com.example.orderservice.Model.OrderModel;
import com.example.orderservice.Routing.PaymentServiceClient;
import com.example.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentServiceClient paymentServiceClient;


    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> Get_example(){
        //String example = "hello";
        return ResponseEntity.ok(paymentServiceClient.hello1());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "Hello, I'm order-service ahihi";
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> CreateOrder(@RequestBody OrderModel orderModel){
        String result = orderService.statusRespone(orderModel);
        return ResponseEntity.ok(result) ;
    }
}

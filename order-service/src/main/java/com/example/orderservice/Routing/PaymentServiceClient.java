package com.example.orderservice.Routing;

import com.example.orderservice.Model.OrderModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE", path = "/api/v1/payments")
public interface PaymentServiceClient {
    @PostMapping(value = "/statusOrder_Payment", produces = "application/json")
    ResponseEntity<OrderModel> statusOrder_Payment(@RequestBody OrderModel orderModel);

    @GetMapping(value = "/hello")
    String hello1();
}

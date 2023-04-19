package com.example.paymentservice.routing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ORDER-SERVICE", path = "/api/v1/orders")
public interface OrderServiceClient {
  @GetMapping
  String hello();
}

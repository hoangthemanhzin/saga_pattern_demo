package com.example.orderservice.Service;

import com.example.orderservice.Model.OrderModel;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    // Hàm trả về trạng thái của Order khi request tới PaymentService :
    public String statusRespone(OrderModel orderModel);
}

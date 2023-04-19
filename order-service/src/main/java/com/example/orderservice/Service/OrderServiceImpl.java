package com.example.orderservice.Service;

import com.example.orderservice.Model.OrderModel;
import com.example.orderservice.Routing.PaymentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private PaymentServiceClient paymentServiceClient;
    // Hàm trả về trạng thái của Order khi request tới PaymentService :
    public String statusRespone(OrderModel orderModel){
        OrderModel OrderModelStatus_Payment = paymentServiceClient.statusOrder_Payment(orderModel).getBody();
        return OrderModelStatus_Payment.getStatus().toString();
    }
}

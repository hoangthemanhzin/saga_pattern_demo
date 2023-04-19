package com.example.paymentservice.Service;

import com.example.paymentservice.Model.OrderModel;
import com.example.paymentservice.Model.PaymentModel;
import com.example.paymentservice.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    public OrderModel statusOrder_Payment(OrderModel orderModel);
}

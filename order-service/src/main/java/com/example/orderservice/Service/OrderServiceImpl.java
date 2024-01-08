package com.example.orderservice.Service;

import com.example.orderservice.Model.OrderModel;
import com.example.orderservice.Routing.PaymentServiceClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @Autowired
    private KafkaTemplate<String,OrderModel> kafkaTemplate;
    // Hàm trả về trạng thái của Order khi request tới PaymentService :
    public String statusRespone(OrderModel orderModel){

        System.out.println(orderModel.toString());
        kafkaTemplate.send("order", orderModel);
        //OrderModel OrderModelStatus_Payment = paymentServiceClient.statusOrder_Payment(orderModel).getBody();
        return "Message has been sent";
    }

}

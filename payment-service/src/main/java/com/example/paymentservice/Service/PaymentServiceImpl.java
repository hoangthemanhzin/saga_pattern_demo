package com.example.paymentservice.Service;

import com.example.paymentservice.Model.OrderModel;
import com.example.paymentservice.Model.PaymentModel;
import com.example.paymentservice.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    //Hàm kiểm tra xem Order đã được qua bước payment hay chưa nếu chưa thì dừng workflow lại
    @Override
    public OrderModel statusOrder_Payment(OrderModel orderModel){
        PaymentModel paymentModel = paymentRepository.finPaymetbyOrderId(orderModel.getId());
        if(paymentModel == null){
            orderModel.setStatus("Order không có trong dữ liệu");
        }else{
            if(orderModel.getAmountAvailable() > paymentModel.getValuePayment() || orderModel.getAmountAvailable() == paymentModel.getValuePayment()){
                orderModel.setStatus(("Đã thanh toán thành công"));
            }else{
                orderModel.setStatus(("Không đủ số dư"));
            }
        }
        return orderModel;
    }
}


package com.example.orderservice.Model;

import lombok.Data;

@Data
public class OrderModel {
    // Id của Order:
    private Integer id;
    // Status của Order:
    private String status;
    // Số tiền hiện có khi thực hiện request Payment :
    private Long amountAvailable;

}

package com.example.paymentservice.Repository;

import com.example.paymentservice.Model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {

    @Query("SELECT u FROM PaymentModel u WHERE u.orderId = :orderid")
    PaymentModel finPaymetbyOrderId(@Param("orderid") Integer orderid);
}

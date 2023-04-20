package com.example.inventoryservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class InventoryListener {

    @KafkaListener(groupId = "pay-gate",
            topics = "${app.message-kafka.topic-name}",
            containerFactory = "listenerContainerFactory")
    public void paymentTransactionReconciliation(Object obj) {

    }

}

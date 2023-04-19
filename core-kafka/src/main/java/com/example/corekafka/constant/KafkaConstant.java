package com.example.corekafka.constant;

import org.springframework.beans.factory.annotation.Value;

public final class KafkaConstant {
  public final static class MessageConstant {
    public static String PAYMENT_RECONCILIATION_TOPIC;
    public static String GROUP_ID = "pay-gate";
  }

  public final static class ConfigConstant {
    @Value("${spring.kafka.bootstrap-servers}")
    public void setServerAddress(String serverAddress){
            ConfigConstant.BOOTSTRAP_SERVER_ADDRESS = serverAddress;
        }
    public static String BOOTSTRAP_SERVER_ADDRESS;
  }
}
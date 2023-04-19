package com.example.corekafka.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

import static com.example.corekafka.constant.KafkaConstant.MessageConstant.GROUP_ID;


public class ConsumerConfigBase <T>{
  @Value("${spring.kafka.bootstrap-servers}")
  private String  bootstrapServerAddress;

  @Bean
  public ConsumerFactory<String, T> consumerFactory() {
    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
    configMap.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
    configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaConsumerFactory<>(configMap);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, T> listenerContainerFactory()
  {
    ConcurrentKafkaListenerContainerFactory<String, T> kafkaListener =
          new ConcurrentKafkaListenerContainerFactory<>();
    kafkaListener.setConsumerFactory(consumerFactory());
    //kafkaListener.setBatchListener(true);     // uncomment if want to get a bulk of message
    return kafkaListener;
  }
}

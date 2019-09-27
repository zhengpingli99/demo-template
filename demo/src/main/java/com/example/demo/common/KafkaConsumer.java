package com.example.demo.common;

import com.example.demo.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Administrator
 */
@Component
@Slf4j
public class KafkaConsumer {
       @KafkaListener(topics = {"topic-ideal"})
       public void consumer(ConsumerRecord<?, ?> record) {
           Optional<?> kafkaMessage = Optional.ofNullable(record.value());
           if (kafkaMessage.isPresent()) {
               Message message = (Message)kafkaMessage.get();
              log.info("----------------- record =" + record);
              log.info("------------------ message =" + message);
              log.info("-----------------"+message.getMsg());
           }

       }
}

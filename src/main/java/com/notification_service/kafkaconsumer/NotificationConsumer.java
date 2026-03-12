package com.notification_service.kafkaconsumer;

import com.onebank.common.events.NotificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class NotificationConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "user-notification", groupId = "notification-group")
    public void consume(String message) {
        try {
//          NotificationEvent event =
//                    objectMapper.readValue(message, NotificationEvent.class);
            System.out.println("✅ Notification received: " + message);
        } catch (Exception e) {
//          Send to DLQ  /  log
            throw new RuntimeException("Kafka deserialization failed", e);
        }
    }
}

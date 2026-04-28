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
            System.out.println("RAW MESSAGE: " + message);

            NotificationEvent event =
                    objectMapper.readValue(message, NotificationEvent.class);

            System.out.println("✅ Notification received: " + event);

        } catch (Exception e) {
            System.out.println("❌ Failed message (ignored, not crashing consumer): " + message);
            e.printStackTrace();
        }
    }
}

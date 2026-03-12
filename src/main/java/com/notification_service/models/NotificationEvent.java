package com.notification_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class NotificationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String message;

}

package com.notification_service.controller;

import com.notification_service.models.NotificationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class NotificationController {

    @PostMapping("/user")
    public ResponseEntity<Void> notify(@RequestBody NotificationEvent notificationEvent){
        return ResponseEntity.ok().build();
    }
}

package org.msa.one.notification.api;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.msa.one.notification.service.Notification;
import org.msa.one.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @SneakyThrows
    @PostMapping
    public void registerCustomer(@RequestBody NotificationRequest notificationRequest) {
        log.info("Income request to register a new customer {}", notificationRequest);
        Notification notification = new Notification();
        notification.setEmail(notificationRequest.email());
        notification.setName(notificationRequest.customerName());
        notification.setCustomerId(notificationRequest.customerId());
        notification.setMessage(notificationRequest.message());

        notificationService.register(notification);
    }

}

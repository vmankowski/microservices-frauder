package org.msa.one.notification.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msa.one.notification.service.Notification;
import org.msa.one.notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;
    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Message received from queue : " + notificationRequest);
        Notification notification = new Notification();

        notification.setName(notificationRequest.toCustomerName());
        notification.setCustomerId(notificationRequest.toCustomerId());
        notification.setMessage(notificationRequest.message());

        notificationService.register(notification);
    }
}
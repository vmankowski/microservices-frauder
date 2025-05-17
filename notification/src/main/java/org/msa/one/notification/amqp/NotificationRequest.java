package org.msa.one.notification.amqp;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {}

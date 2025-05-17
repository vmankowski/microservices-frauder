package org.msa.one.notification.api;

public record NotificationRequest(Integer customerId, String customerName, String message, String email) {
}

package org.msa.one.customer.service;

public record NotificationRequest(Integer customerId, String customerName, String message, String email) {
}

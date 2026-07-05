package com.danilodps.webhook.adapters.inbound.controller.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponse(String webhookId, BigDecimal amount, String paymentStatus, LocalDateTime createdAt, LocalDateTime updatedDate) {
}

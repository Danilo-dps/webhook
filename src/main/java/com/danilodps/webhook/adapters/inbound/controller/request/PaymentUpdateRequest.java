package com.danilodps.webhook.adapters.inbound.controller.request;

import java.time.LocalDateTime;

public record PaymentUpdateRequest(String paymentId, String paymentStatus, String webhookId, LocalDateTime updatedDate) { }

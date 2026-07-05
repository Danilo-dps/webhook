package com.danilodps.webhook.adapters.inbound.controller.request;

import java.math.BigDecimal;

public record PaymentRequest(BigDecimal amount) { }

package com.danilodps.webhook.domain.mappers.core;

import com.danilodps.webhook.adapters.inbound.controller.response.PaymentResponse;
import com.danilodps.webhook.domain.model.PaymentEntity;

import java.util.Optional;

public class PaymentEntity2PaymentResponse {

    private PaymentEntity2PaymentResponse(){}

    public static PaymentResponse convert(PaymentEntity paymentEntity){
        return new PaymentResponse(
                Optional.ofNullable(paymentEntity.getWebhookId()).orElse(null),
                paymentEntity.getPaymentAmount(),
                paymentEntity.getPaymentStatus(),
                paymentEntity.getPaymentDate());
    }

}

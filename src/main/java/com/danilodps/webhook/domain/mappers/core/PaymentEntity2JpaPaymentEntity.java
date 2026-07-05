package com.danilodps.webhook.domain.mappers.core;

import com.danilodps.webhook.adapters.outbound.entities.JpaPaymentEntity;
import com.danilodps.webhook.domain.model.PaymentEntity;

import java.util.Optional;

public class PaymentEntity2JpaPaymentEntity {

    private PaymentEntity2JpaPaymentEntity(){}

    public static JpaPaymentEntity convert(PaymentEntity paymentEntity){
        return new JpaPaymentEntity(
                paymentEntity.getPaymentId(),
                paymentEntity.getPaymentAmount(),
                paymentEntity.getPaymentStatus(),
                Optional.ofNullable(paymentEntity.getWebhookId()).orElse(null),
                paymentEntity.getCreatedDate(),
                Optional.ofNullable(paymentEntity.getUpdatedDate()).orElse(null));
    }

}

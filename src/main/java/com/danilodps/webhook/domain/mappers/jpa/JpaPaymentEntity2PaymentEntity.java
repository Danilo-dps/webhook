package com.danilodps.webhook.domain.mappers.jpa;

import com.danilodps.webhook.adapters.outbound.entities.JpaPaymentEntity;
import com.danilodps.webhook.domain.model.PaymentEntity;

import java.util.Optional;

public class JpaPaymentEntity2PaymentEntity {

    private JpaPaymentEntity2PaymentEntity(){}

    public static PaymentEntity convert(JpaPaymentEntity jpaPaymentEntity){
        return new PaymentEntity(
                jpaPaymentEntity.getPaymentId(),
                jpaPaymentEntity.getPaymentDate(),
                jpaPaymentEntity.getPaymentAmount(),
                jpaPaymentEntity.getPaymentStatus(),
                Optional.ofNullable(jpaPaymentEntity.getWebhookId()).orElse(null));
    }

}

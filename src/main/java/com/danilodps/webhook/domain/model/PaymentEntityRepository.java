package com.danilodps.webhook.domain.model;

import com.danilodps.webhook.adapters.inbound.controller.request.PaymentUpdateRequest;

import java.util.Optional;

public interface PaymentEntityRepository {

    PaymentEntity save(PaymentEntity paymentEntity);
    Optional<PaymentEntity> findByPaymentId(String paymentId);
    Optional<PaymentEntity> update(PaymentUpdateRequest paymentUpdateRequest);

}

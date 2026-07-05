package com.danilodps.webhook.domain.model;

import java.util.Optional;

public interface PaymentEntityRepository {

    PaymentEntity save(PaymentEntity paymentEntity);
    Optional<PaymentEntity> findByPaymentId(String paymentId);

}

package com.danilodps.webhook.application.usecases;

import com.danilodps.webhook.adapters.inbound.controller.request.PaymentRequest;
import com.danilodps.webhook.adapters.inbound.controller.response.PaymentResponse;

public interface PaymentUseCase {

    PaymentResponse create(PaymentRequest paymentRequest);
    PaymentResponse findByPaymentId(String paymentId);

}

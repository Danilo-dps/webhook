package com.danilodps.webhook.application.impl;

import com.danilodps.webhook.adapters.inbound.controller.request.PaymentRequest;
import com.danilodps.webhook.adapters.inbound.controller.response.PaymentResponse;
import com.danilodps.webhook.application.usecases.PaymentUseCase;
import com.danilodps.webhook.domain.mappers.core.PaymentEntity2PaymentResponse;
import com.danilodps.webhook.domain.model.PaymentEntity;
import com.danilodps.webhook.domain.model.PaymentEntityRepository;
import com.danilodps.webhook.domain.model.enums.PaymentEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentUseCase {

    private final PaymentEntityRepository  paymentEntityRepository;

    @Override
    public PaymentResponse create(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = null;
        if(nonNull(paymentRequest)){
            paymentEntity = new PaymentEntity(
                    UUID.randomUUID().toString(),
                    paymentRequest.amount(),
                    PaymentEnum.EM_ANDAMENTO.getDescription(),
                    LocalDateTime.now(ZoneId.systemDefault()));
        }

        paymentEntity = paymentEntityRepository.save(paymentEntity);

        return PaymentEntity2PaymentResponse.convert(paymentEntity);
    }

    @Override
    public PaymentResponse findByPaymentId(String paymentId) {
        return this.paymentEntityRepository.findByPaymentId(paymentId)
                .map(PaymentEntity2PaymentResponse::convert)
                .orElse(null);
    }

}

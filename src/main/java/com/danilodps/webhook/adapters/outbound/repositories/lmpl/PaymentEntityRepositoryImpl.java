package com.danilodps.webhook.adapters.outbound.repositories.lmpl;

import com.danilodps.webhook.adapters.inbound.controller.request.PaymentUpdateRequest;
import com.danilodps.webhook.adapters.outbound.entities.JpaPaymentEntity;
import com.danilodps.webhook.adapters.outbound.repositories.JpaPaymentEntityRepository;
import com.danilodps.webhook.domain.mappers.core.PaymentEntity2JpaPaymentEntity;
import com.danilodps.webhook.domain.mappers.jpa.JpaPaymentEntity2PaymentEntity;
import com.danilodps.webhook.domain.model.PaymentEntity;
import com.danilodps.webhook.domain.model.PaymentEntityRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Repository
public class PaymentEntityRepositoryImpl implements PaymentEntityRepository {

    private final JpaPaymentEntityRepository jpaPaymentEntityRepository;

    public PaymentEntityRepositoryImpl(JpaPaymentEntityRepository jpaPaymentEntityRepository) {
        this.jpaPaymentEntityRepository = jpaPaymentEntityRepository;
    }

    @Override
    public PaymentEntity save(PaymentEntity paymentEntity) {
        JpaPaymentEntity jpaPaymentEntity = this.jpaPaymentEntityRepository.saveAndFlush(PaymentEntity2JpaPaymentEntity.convert(paymentEntity));
        return JpaPaymentEntity2PaymentEntity.convert(jpaPaymentEntity);
    }

    @Override
    public Optional<PaymentEntity> findByPaymentId(String paymentId) {
        Optional<JpaPaymentEntity> optJpaPaymentEntity = this.jpaPaymentEntityRepository.findByPaymentId(paymentId);
        return optJpaPaymentEntity.map(JpaPaymentEntity2PaymentEntity::convert).or(Optional::empty);
    }

    @Override
    public Optional<PaymentEntity> update(PaymentUpdateRequest paymentUpdateRequest) {
        Optional<JpaPaymentEntity> optJpaPaymentEntity = Optional.empty();
        if(nonNull(paymentUpdateRequest)){
            optJpaPaymentEntity = this.jpaPaymentEntityRepository.updatePaymentFields(
                    paymentUpdateRequest.paymentId(),
                    paymentUpdateRequest.paymentStatus(),
                    paymentUpdateRequest.webhookId(),
                    LocalDateTime.now(ZoneId.systemDefault()));
        }
        return optJpaPaymentEntity.map(JpaPaymentEntity2PaymentEntity::convert).or(Optional::empty);
    }

}

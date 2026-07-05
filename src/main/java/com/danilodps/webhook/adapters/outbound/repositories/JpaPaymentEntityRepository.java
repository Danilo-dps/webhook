package com.danilodps.webhook.adapters.outbound.repositories;

import com.danilodps.webhook.adapters.outbound.entities.JpaPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPaymentEntityRepository extends JpaRepository<JpaPaymentEntity, String> {

    Optional<JpaPaymentEntity> findByPaymentId(String paymentId);

}

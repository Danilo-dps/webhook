package com.danilodps.webhook.adapters.outbound.repositories;

import com.danilodps.webhook.adapters.outbound.entities.JpaPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaPaymentEntityRepository extends JpaRepository<JpaPaymentEntity, String> {

    Optional<JpaPaymentEntity> findByPaymentId(String paymentId);

    @Modifying
    @Query("UPDATE JpaPaymentEntity p SET p.paymentStatus = :paymentStatus, p.webhookId = :webhookId, p.updatedDate = :updatedDate WHERE p.paymentId = :paymentId")
    Optional<JpaPaymentEntity> updatePaymentFields(
            @Param("paymentId") String paymentId,
            @Param("paymentStatus") String paymentStatus,
            @Param("webhookId") String webhookId,
            @Param("updatedDate") LocalDateTime updatedDate);

}

package com.danilodps.webhook.adapters.outbound.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PAYMENT")
@EqualsAndHashCode(of = "paymentId")
public class JpaPaymentEntity {

    private String paymentId;
    private LocalDateTime paymentDate;
    private BigDecimal paymentAmount;
    private String paymentStatus;
    private String webhookId;

}

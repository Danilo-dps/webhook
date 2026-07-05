package com.danilodps.webhook.adapters.outbound.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
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
public class JpaPaymentEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PAYMENT_ID", updatable = false, nullable = false)
    private String paymentId;

    @Column(name = "PAYMENT_AMOUNT", nullable = false, updatable = false)
    private BigDecimal paymentAmount;

    @Column(name = "PAYMENT_STATUS", nullable = false)
    private String paymentStatus;

    @Column(name = "WEBHOOK_ID" )
    private String webhookId;

    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updatedDate;

}

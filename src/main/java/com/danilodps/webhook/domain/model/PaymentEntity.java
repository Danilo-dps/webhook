package com.danilodps.webhook.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PaymentEntity {

    private String paymentId;
    private BigDecimal paymentAmount;
    private String paymentStatus;
    private String webhookId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public PaymentEntity() {}

    public PaymentEntity(String paymentId,
                         BigDecimal paymentAmount,
                         String paymentStatus,
                         String webhookId,
                         LocalDateTime createdDate,
                         LocalDateTime updatedDate) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.webhookId = webhookId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public PaymentEntity(String paymentId,
                         BigDecimal paymentAmount,
                         String paymentStatus,
                         LocalDateTime createdDate) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.createdDate = createdDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getWebhookId() {
        return webhookId;
    }

    public void setWebhookId(String webhookId) {
        this.webhookId = webhookId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PaymentEntity that)) return false;
        return Objects.equals(paymentId, that.paymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(paymentId);
    }

}


package com.danilodps.webhook.domain.model.enums;

import lombok.Getter;

@Getter
public enum PaymentEnum {

    EM_ANDAMENTO(1L, "EM ANDAMENTO"),
    CONCLUIDA(2L, "CONCLUÍDA");

    private final Long id;
    private final String description;

    PaymentEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

}

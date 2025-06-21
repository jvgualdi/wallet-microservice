package jvgualdi.tec.wallet.microservice.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderCreatedEvent(Long customerId, @Positive BigDecimal total, String orderId) {
}

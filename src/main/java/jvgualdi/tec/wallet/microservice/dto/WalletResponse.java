package jvgualdi.tec.wallet.microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record WalletResponse (@JsonProperty("customer_id") Long customerId, BigDecimal balance) {
}

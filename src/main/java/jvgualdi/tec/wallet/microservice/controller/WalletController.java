package jvgualdi.tec.wallet.microservice.controller;

import jakarta.validation.constraints.Positive;
import jvgualdi.tec.wallet.microservice.dto.WalletResponse;
import jvgualdi.tec.wallet.microservice.mapper.WalletMapper;
import jvgualdi.tec.wallet.microservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService service;
    private final WalletMapper mapper;

    @GetMapping("/{customerId}")
    public ResponseEntity<WalletResponse> get(@PathVariable Long customerId) {
        var wallet = service.getOrCreate(customerId);
        var walletResponse = mapper.toResponse(wallet);
        return ResponseEntity.ok(walletResponse);
    }

    @PostMapping("/{customerId}/topup")
    public ResponseEntity<WalletResponse> topUp(
            @PathVariable Long customerId,
            @RequestParam @Positive BigDecimal amount) {
        var walletResponse = service.topUp(customerId, amount);
        return ResponseEntity.ok(walletResponse);
    }
}
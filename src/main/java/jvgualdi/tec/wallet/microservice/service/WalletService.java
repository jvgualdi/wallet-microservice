package jvgualdi.tec.wallet.microservice.service;

import jvgualdi.tec.wallet.microservice.domain.Wallet;
import jvgualdi.tec.wallet.microservice.dto.WalletResponse;
import jvgualdi.tec.wallet.microservice.mapper.WalletMapper;
import jvgualdi.tec.wallet.microservice.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
// RabbitMQ desativado - testando o serviço isolado.
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import java.util.Map;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    // private final RabbitTemplate rabbit;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet getOrCreate(Long customerId) {
        return walletRepository.findByCustomerId(customerId)
                .orElseGet(() -> walletRepository.save(new Wallet(null, customerId, BigDecimal.valueOf(1000))));
    }

    public WalletResponse topUp(Long customerId, BigDecimal amount) {
        var w = getOrCreate(customerId);
        w.setBalance(w.getBalance().add(amount));
        walletRepository.save(w);
        return WalletMapper.toResponse(w);
    }

    public void debit(Long customerId, BigDecimal amount, String orderId) {
        var wallet = getOrCreate(customerId);
        if (wallet.getBalance().compareTo(amount) >= 0) {
            wallet.setBalance(wallet.getBalance().subtract(amount));
            walletRepository.save(wallet);
            // rabbit.convertAndSend("wallet.events", "wallet.debited",
            //         Map.of("customerId", customerId, "orderId", orderId));
        } else {
            // rabbit.convertAndSend("wallet.events", "wallet.insufficient",
            //         Map.of("customerId", customerId, "orderId", orderId));
        }
    }

}

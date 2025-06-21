package jvgualdi.tec.wallet.microservice.events;

import jvgualdi.tec.wallet.microservice.dto.OrderCreatedEvent;
import jvgualdi.tec.wallet.microservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventListener {

    private final WalletService walletService;

    @RabbitListener(queues = "order.created")
    public void onOrderCreated(OrderCreatedEvent evt) {
        walletService.debit(evt.customerId(), evt.total(), evt.orderId());
    }
}
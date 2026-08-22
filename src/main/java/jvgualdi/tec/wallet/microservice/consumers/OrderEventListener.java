package jvgualdi.tec.wallet.microservice.consumers;

// RabbitMQ desativado - testando o serviço isolado. Classe inteira comentada abaixo.
// ATENÇÃO: o queues="{spring.rabbitmq.queue}" original está sem o "$" (deveria ser
// "${spring.rabbitmq.queue}") - corrigir isso ao reativar o RabbitMQ.

//import jvgualdi.tec.wallet.microservice.dto.OrderCreatedEvent;
//import jvgualdi.tec.wallet.microservice.service.WalletService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class OrderEventListener {
//
//    private final WalletService walletService;
//
//    @RabbitListener(queues = "{spring.rabbitmq.queue}")
//    public void onOrderCreated(@Payload OrderCreatedEvent evt) {
//        walletService.debit(evt.customerId(), evt.total(), evt.orderId());
//    }
//}

package org.msa.one.customer.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(String exchange, String routingKey, Object payload) {
        log.info("Publishing to {} using routingKey {}.", exchange, routingKey);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
    }
}
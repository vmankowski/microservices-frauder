package org.msa.one.customer.service;

import lombok.extern.slf4j.Slf4j;
import org.msa.one.customer.amqp.RabbitMQMessageProducer;
import org.msa.one.customer.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, RabbitMQMessageProducer rabbitMQMessageProducer) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
    }

    public void register(Customer customer) throws IllegalAccessException {
        log.info("Try to store a new customer to DB {}", customer);
        //TODO validate email is not empty
        //TODO validate name is not empty
        customerRepository.saveAndFlush(customer);
        //TODO is suspicious object
        Boolean fraudCheckResponse = restTemplate
                .getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", Boolean.class, customer.getId());
        log.info("Customer was saved to DB {}", customer);
        //TODO check if customer is a fraudster
        if (fraudCheckResponse) {
            log.warn("Customer is suspicious object!", customer);
            throw new IllegalAccessException("It's a fraudster with customer ID " + customer.getId());
        }
        log.info("Customer is not a suspicious object!", customer);

        //TODO send notification to police
//        restTemplate.postForObject("http://NOTIFICATION/api/v1/notifications",
//                new NotificationRequest(Math.toIntExact(customer.getId()), customer.getName(), "Dear Customer, you have been registered!", customer.getEmail()),
//                Void.class);
        rabbitMQMessageProducer.publish("internal.exchange",
                "internal.notification.routing-key",
                new NotificationRequest(
                        Math.toIntExact(customer.getId()),
                        customer.getName(),
                        "Dear Customer, you have been registered!",
                        customer.getEmail()));
    }


}

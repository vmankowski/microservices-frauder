package org.msa.one.customer.service;

import lombok.extern.slf4j.Slf4j;
import org.msa.one.customer.repo.CustomerRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void register(Customer customer) {
        log.info("Try to store a new customer to DB {}", customer);
        //TODO validate email is not empty
        //TODO validate name is not empty
        //TODO store DB
        customerRepository.save(customer);

    }

}

package org.msa.one.customer.api;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.msa.one.customer.service.Customer;
import org.msa.one.customer.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @SneakyThrows
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Income request to register a new customer {}", customerRegistrationRequest);
        //TODO change to builder
        Customer customer = new Customer();
        customer.setEmail(customerRegistrationRequest.email());
        customer.setName(customerRegistrationRequest.firstName());
        customer.setSurName(customerRegistrationRequest.lastName());

        customerService.register(customer);
    }

}

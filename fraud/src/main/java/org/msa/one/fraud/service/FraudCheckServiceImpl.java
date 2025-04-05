package org.msa.one.fraud.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.msa.one.fraud.repository.FraudCustomerEntity;
import org.msa.one.fraud.repository.FraudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudRepository fraudRepository;
    @Override
    public boolean isSuspicious(Integer customerId) {
        FraudCustomerEntity isSuspiciousCustomer = fraudRepository.findByCustomerId(customerId);
        log.info("Try to looking for customer with ID: {}", customerId);
        if (isSuspiciousCustomer == null) {
            log.info("Customer with ID {} does not exist!", customerId);
            log.info("Customer with ID {} is not a suspicious object!", customerId);
            return false;
        }

        if (isSuspiciousCustomer.getIsBargary() || isSuspiciousCustomer.getIsThief() || isSuspiciousCustomer.getIsTerrorist()) {
            log.info("Customer with ID {} has a problem: {}", customerId, isSuspiciousCustomer);
            return true;
        }

        log.info("I do not know what happen with customer {}", customerId);
        return false;
    }

    @Override
    public List<FraudCustomerEntity> getAllFraudCustomers() {
        return fraudRepository.findAll();
    }
}

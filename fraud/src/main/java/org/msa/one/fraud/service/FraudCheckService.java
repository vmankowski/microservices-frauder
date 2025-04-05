package org.msa.one.fraud.service;

import org.msa.one.fraud.repository.FraudCustomerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FraudCheckService {

    boolean isSuspicious(Integer customerId);

    List<FraudCustomerEntity> getAllFraudCustomers();
}

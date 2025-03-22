package org.msa.one.fraud.service;

import org.springframework.stereotype.Service;

public interface FraudCheckService {

    boolean isSuspicious(Integer customerId);
}

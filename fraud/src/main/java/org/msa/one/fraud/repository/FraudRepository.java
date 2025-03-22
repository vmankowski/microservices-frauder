package org.msa.one.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudRepository extends JpaRepository<FraudCustomerEntity, Long> {

    FraudCustomerEntity findByCustomerId(Integer customerId);
}

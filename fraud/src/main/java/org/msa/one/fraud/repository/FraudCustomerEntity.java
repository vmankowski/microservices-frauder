package org.msa.one.fraud.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FraudCustomerEntity {

    @Id
    private Long id;

    private Integer customerId;
    private Boolean isFraudster;
    private Boolean isTerrorist;
    private Boolean isBargary;
    private Boolean isThief;

    private LocalDateTime createdAt;

}

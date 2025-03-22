package org.msa.one.fraud.api;

import lombok.AllArgsConstructor;
import org.msa.one.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@RestController
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public boolean isSuspicious(@PathVariable("customerId") Integer customerId) {

        return fraudCheckService.isSuspicious(customerId);
    }

    @GetMapping
    public String ping() {
        return "pong";
    }



}

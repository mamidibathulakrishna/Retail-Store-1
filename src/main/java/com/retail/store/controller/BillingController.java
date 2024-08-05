package com.retail.store.controller;

import com.retail.store.dto.BillingRequest;
import com.retail.store.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling billing operations.
 */
@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/calculateNetPayableAmount")
    public double calculateNetPayableAmount(@RequestBody BillingRequest billingRequest) {
        return billingService.calculateNetPayableAmount(
                billingRequest.getUser(),
                billingRequest.getItems()
        );
    }
}


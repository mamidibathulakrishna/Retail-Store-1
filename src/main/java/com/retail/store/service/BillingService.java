package com.retail.store.service;

import com.retail.store.model.Item;
import com.retail.store.model.User;

import java.util.List;

/**
 * Service interface for handling billing operations.
 */
public interface BillingService {

    /**
     * Calculates the net payable amount after applying discounts based on user and items.
     *
     * @param user  The user making the purchase.
     * @param items The list of items in the purchase.
     * @return The net payable amount after applying discounts.
     */
    double calculateNetPayableAmount(User user, List<Item> items);
}


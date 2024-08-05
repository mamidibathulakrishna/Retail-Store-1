package com.retail.store.service;

import com.retail.store.model.Item;
import com.retail.store.model.User;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of {@link BillingService}.
 */
@Service
public class BillingServiceImpl implements BillingService {

    private static final double PER_HUNDRED_DISCOUNT_AMOUNT = 5.0;
    private static final double EMPLOYEE_DISCOUNT_RATE = 0.3;
    private static final double AFFILIATE_DISCOUNT_RATE = 0.1;
    private static final double LOYALTY_DISCOUNT_RATE = 0.05;

    /**
     * Calculates the net payable amount after applying discounts based on user and items.
     *
     * @param user  The user making the purchase.
     * @param items The list of items in the purchase.
     * @return The net payable amount after applying discounts.
     */
    @Override
    public double calculateNetPayableAmount(User user, List<Item> items) {
        double totalBillAmount = calculateTotalBill(items);
        double discountAmount = calculateDiscount(user, items, totalBillAmount);
        return totalBillAmount - discountAmount;
    }

    private double calculateTotalBill(List<Item> items) {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    private double calculateDiscount(User user, List<Item> items, double totalBillAmount) {
        double discount = 0.0;

        // Calculate $5 discount for every $100 on the bill
        discount += Math.floor(totalBillAmount / 100) * PER_HUNDRED_DISCOUNT_AMOUNT;
        // Percentage based discounts (only apply to non-grocery items)
        if (!items.isEmpty()) {
            for (Item item : items) {
                if (!item.isGrocery()) {
                    switch (user.getUserType()) {
                        case EMPLOYEE:
                            discount += totalBillAmount * EMPLOYEE_DISCOUNT_RATE;
                            return discount;
                        case AFFILIATE:
                            discount += totalBillAmount * AFFILIATE_DISCOUNT_RATE;
                            return discount;
                        case CUSTOMER:
                            if (isEligibleForLoyaltyDiscount(user)) {
                                discount += totalBillAmount * LOYALTY_DISCOUNT_RATE;
                                return discount;
                            }
                            break;
                    }
                }
            }
        }

        return discount;
    }

    private boolean isEligibleForLoyaltyDiscount(User user) {
        LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
        return user.getMemberSince().isBefore(twoYearsAgo);
    }
}


package com.retail.store.service;

import com.retail.store.model.Item;
import com.retail.store.model.User;
import com.retail.store.model.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BillingServiceTest {

    @Mock
    private User mockUser;

    @InjectMocks
    private BillingServiceImpl billingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateNetPayableAmount_NoDiscount() {
        when(mockUser.getUserType()).thenReturn(UserType.CUSTOMER);
        when(mockUser.getMemberSince()).thenReturn(LocalDate.now().minusYears(1)); // Not eligible for loyalty discount
        Item item = new Item("NonGrocery", 95.0, false);
        double netPayableAmount = billingService.calculateNetPayableAmount(mockUser, Collections.singletonList(item));

        assertEquals(95.0, netPayableAmount); //$5 off on $100 bill
    }

    @Test
    public void testCalculateNetPayableAmount_WithOffOnHundredBill() {
        when(mockUser.getUserType()).thenReturn(UserType.CUSTOMER);
        when(mockUser.getMemberSince()).thenReturn(LocalDate.now().minusYears(1)); // Not eligible for loyalty discount
        Item item = new Item("NonGrocery", 100.0, false);
        double netPayableAmount = billingService.calculateNetPayableAmount(mockUser, Collections.singletonList(item));

        assertEquals(95.0, netPayableAmount); //$5 off on $100 bill
    }

    @Test
    public void testCalculateNetPayableAmount_EmployeeDiscount() {
        when(mockUser.getUserType()).thenReturn(UserType.EMPLOYEE);
        Item item = new Item("NonGrocery", 100.0, false);
        double netPayableAmount = billingService.calculateNetPayableAmount(mockUser, Collections.singletonList(item));

        assertEquals(65.0, netPayableAmount); // Employee Discount 30% + $5 off on $100 bill
    }

    @Test
    public void testCalculateNetPayableAmount_AffiliateDiscount() {
        when(mockUser.getUserType()).thenReturn(UserType.AFFILIATE);
        Item item = new Item("NonGrocery", 100.0, false);
        double netPayableAmount = billingService.calculateNetPayableAmount(mockUser, Collections.singletonList(item));

        assertEquals(85.0, netPayableAmount); // Employee Discount 10% + $5 off on $100 bill
    }

    @Test
    public void testCalculateNetPayableAmount_WithDiscount() {
        // Mock user for the test
        when(mockUser.getUserType()).thenReturn(UserType.CUSTOMER);
        when(mockUser.getMemberSince()).thenReturn(LocalDate.now().minusYears(3)); // Eligible for loyalty discount

        // Mock items for the test
        Item item1 = new Item("NonGrocery", 500.0, false);
        Item item2 = new Item("NonGrocery", 500.0, false); // Total: 990.0

        double netPayableAmount = billingService.calculateNetPayableAmount(mockUser, Arrays.asList(item1, item2));

        assertEquals(900.0, netPayableAmount); // Expected discount: 5% discount ($50) + $5 off on $100 bill ($50 (10 * $5))
    }

    // Add more tests for affiliate discount, $5 discount, combinations, etc.
}



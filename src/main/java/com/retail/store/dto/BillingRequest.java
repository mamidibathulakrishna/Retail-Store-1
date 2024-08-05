package com.retail.store.dto;

import com.retail.store.model.Item;
import com.retail.store.model.User;

import java.util.List;

public class BillingRequest {

    private User user;
    private List<Item> items;

    public BillingRequest(User user, List<Item> items) {
        this.user = user;
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}


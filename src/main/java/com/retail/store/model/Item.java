package com.retail.store.model;

/**
 * Represents an item that can be purchased.
 */
public class Item {

    private String name;
    private double price;
    private boolean isGrocery;

    /**
     * Constructs an item with specified name, price, and type.
     *
     * @param name    The name of the item.
     * @param price   The price of the item.
     * @param isGrocery Whether the item is classified as grocery.
     */
    public Item(String name, double price, boolean isGrocery) {
        this.name = name;
        this.price = price;
        this.isGrocery = isGrocery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isGrocery() {
        return isGrocery;
    }

    public void setGrocery(boolean grocery) {
        isGrocery = grocery;
    }
}

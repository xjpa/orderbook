package com.johnamata.orderbook.core;

//for trade orders
public class Order {
    private static int idCounter = 0; // To generate unique IDs for orders
    private final int orderId; // unique order ID
    private final double price; // price at which order is placed
    private final String type;  // MARKET or LIMIT
    private final String action; // BUY or SELL
    private int quantity; // quantity of stocks/shares

    public Order(double price, int quantity, String type, String action) {
        this.orderId = ++idCounter;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.action = action;
    }

   // getters

    public int getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }

    public void reduceQuantity(int amount) {
        if (amount > this.quantity) {
            throw new IllegalArgumentException("Amount to reduce exceeds order quantity.");
        }
        this.quantity -= amount;
    }


    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public String getAction() {
        return action;
    }
}

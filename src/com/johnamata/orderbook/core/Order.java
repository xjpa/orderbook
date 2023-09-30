package com.johnamata.orderbook.core;

//for trade orders
public class Order {
    private static int idCounter = 0; // To generate unique IDs for orders
    private final int orderId; // unique order ID
    private final double price; // price at which order is placed
    private final int quantity; // quantity of stocks/shares
    private final String type;  // MARKET or LIMIT
    private final String action; // BUY or SELL

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

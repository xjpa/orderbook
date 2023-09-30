package com.johnamata.orderbook.core;

import java.util.ArrayList;
import java.util.List;

public class OrderBook {
    private final List<Order> buyOrders;
    private final List<Order> sellOrders;

    public OrderBook() {
        this.buyOrders = new ArrayList<>();
        this.sellOrders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (order.getAction().equals("BUY")) {
            buyOrders.add(order);
        } else if (order.getAction().equals("SELL")) {
            sellOrders.add(order);
        }
        // todo: sort or match orders
    }

    public List<Order> getBuyOrders() {
        return buyOrders;
    }

    public List<Order> getSellOrders() {
        return sellOrders;
    }

    // todo: methods for matching orders, removing filled orders, etc.
}

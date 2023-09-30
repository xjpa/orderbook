package com.johnamata.orderbook.core;

import java.util.ArrayList;
import java.util.Comparator;
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
            buyOrders.sort(Comparator.comparingDouble(Order::getPrice).reversed());
        } else if (order.getAction().equals("SELL")) {
            sellOrders.add(order);
            sellOrders.sort(Comparator.comparingDouble(Order::getPrice));
        }
        // try to match orders after every addition
        matchOrders();
    }

    private void matchOrders() {
        while (!buyOrders.isEmpty() && !sellOrders.isEmpty()) {
            Order topBuy = buyOrders.get(0);
            Order topSell = sellOrders.get(0);

            if (topBuy.getPrice() >= topSell.getPrice()) {
                int matchedQty = Math.min(topBuy.getQuantity(), topSell.getQuantity());
                topBuy.reduceQuantity(matchedQty);
                topSell.reduceQuantity(matchedQty);

                // remove orders if their quantity has reached 0
                if (topBuy.getQuantity() == 0) {
                    buyOrders.remove(0);
                }
                if (topSell.getQuantity() == 0) {
                    sellOrders.remove(0);
                }
            } else {
                break; // No match found, exit
            }
        }
    }

    public List<Order> getBuyOrders() {
        return buyOrders;
    }

    public List<Order> getSellOrders() {
        return sellOrders;
    }
}

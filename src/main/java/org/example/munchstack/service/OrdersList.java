package org.example.munchstack.service;

import java.math.BigDecimal;

public interface OrdersList<T> {
    void addOrder(T order);

    void removeOrder(T order);

    void updateOrder(T order);

    T getOrder(String name);

    T getRecentOrder();

    T getEarliestOrder();

    int getOrderCount();

    BigDecimal getTotalCost();

    void clearOrders();

    String listOrders();

    boolean isEmpty();
}

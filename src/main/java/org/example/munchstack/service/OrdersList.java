package org.example.munchstack.service;

import java.math.BigDecimal;

public interface OrdersList<T> {
    void addOrder(T order);

    void removeOrder(T order);

    void updateOrder(T order);

    T getOrder(String name);

    T getMostRecentOrder();

    T getEarliestOrder();

    int getOrderCount();

    BigDecimal getTotalCost();

    void clearOrders();

    void listOrders();

    boolean isEmpty();
}

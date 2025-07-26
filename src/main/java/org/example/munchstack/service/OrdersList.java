package org.example.munchstack.service;

public interface OrdersList<T> {
    void addOrder(T order);

    void removeOrder(T order);

    void updateOrder(T order);

    T getOrder(String name);

    T getRecentOrder();

    T getEarliestOrder();

    int getOrderCount();

    void clearOrders();

    String listOrders();

    boolean isEmpty();
}

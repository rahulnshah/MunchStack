package org.example.munchstack.service;

public interface OrdersList<T> {
    void addOrder(T order);
    void removeOrder(T order);
    void updateOrder(T order);
    T getOrder(String name);
    int getOrderCount();
    void clearOrders();
    String listOrders();
    boolean isEmpty();
}

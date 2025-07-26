package org.example.munchstack.impl;

import org.example.munchstack.model.FastFood;
import org.example.munchstack.service.OrdersList;

public class FastFoodOrders implements OrdersList<FastFood> {

    @Override
    public void addOrder(FastFood order) {

    }

    @Override
    public void removeOrder(FastFood order) {

    }

    @Override
    public void updateOrder(FastFood order) {

    }

    @Override
    public FastFood getOrder(int index) {
        return null;
    }

    @Override
    public int getOrderCount() {
        return 0;
    }

    @Override
    public void clearOrders() {

    }

    @Override
    public String listOrders() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

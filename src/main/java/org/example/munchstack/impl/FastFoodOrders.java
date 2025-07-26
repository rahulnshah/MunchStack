package org.example.munchstack.impl;

import org.example.munchstack.model.FastFood;
import org.example.munchstack.service.OrdersList;

import java.math.BigDecimal;
import java.util.*;

public class FastFoodOrders implements OrdersList<FastFood> {

    private final List<FastFood> orders;

    public FastFoodOrders() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void addOrder(FastFood order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(FastFood order) {
        Optional<FastFood> orderToRemove = Optional.ofNullable(getOrder(order.getName()));
        orderToRemove.ifPresent(orders::remove);
    }

    @Override
    public void updateOrder(FastFood order) {
        Optional<FastFood> orderToUpdate = Optional.ofNullable(getOrder(order.getName()));
        orderToUpdate.ifPresent(existingOrder -> {
            existingOrder.setQuantity(order.getQuantity());
            existingOrder.setPrice(order.getPrice());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setCreatedAt(order.getCreatedAt());
        });
    }

    @Override
    public FastFood getOrder(String name) {
        return orders.stream()
                .filter(o -> o.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getOrderCount() {
        return orders.size();
    }

    @Override
    public void clearOrders() {
        orders.clear();
    }

    @Override
    public String listOrders() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return orders.isEmpty();
    }

    @Override
    public FastFood getRecentOrder() {
        sortByDate();
        return orders.getFirst();
    }

    @Override
    public FastFood getEarliestOrder() {
        sortByDate();
        return orders.getLast();
    }

    private void sortByDate() {
        orders.sort(Comparator.comparing(FastFood::getCreatedAt).reversed());
    }

    @Override
    public BigDecimal getTotalCost() {
        return orders.stream()
                .map(order -> order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}

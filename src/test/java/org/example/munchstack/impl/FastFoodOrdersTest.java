package org.example.munchstack.impl;

import org.example.munchstack.enums.STATUS;
import org.example.munchstack.model.FastFood;
import org.example.munchstack.service.OrdersList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FastFoodOrdersTest {

    private OrdersList<FastFood> orders;

    private FastFood mockFood1;

    private FastFood mockFood2;

    @BeforeEach
    void setUp() {
        this.mockFood1 = mock(FastFood.class);
        this.mockFood2 = mock(FastFood.class);
        orders = new FastFoodOrders();

        // Setup mock behaviors
        when(mockFood1.getName()).thenReturn("Pizza");
        when(mockFood1.getPrice()).thenReturn(new BigDecimal("10.00"));
        when(mockFood1.getQuantity()).thenReturn(2);
        when(mockFood1.getCreatedAt()).thenReturn(new Date());

        when(mockFood2.getName()).thenReturn("Burger");
        when(mockFood2.getPrice()).thenReturn(new BigDecimal("5.00"));
        when(mockFood2.getQuantity()).thenReturn(1);
        when(mockFood2.getCreatedAt()).thenReturn(new Date(System.currentTimeMillis() - 1000));
    }

    @Test
    void testAddOrder() {
        orders.addOrder(mockFood1);
        assertEquals(1, orders.getOrderCount());
        assertEquals(mockFood1, orders.getOrder("Pizza"));
    }

    @Test
    void testRemoveOrder() {
        orders.addOrder(mockFood1);
        orders.removeOrder(mockFood1);
        assertTrue(orders.isEmpty());
    }

    @Test
    void testUpdateOrder() {
        orders.addOrder(mockFood1);

        FastFood updatedFood = mockFood1;
        when(updatedFood.getQuantity()).thenReturn(3);
        when(updatedFood.getPrice()).thenReturn(new BigDecimal("15.00"));
        when(updatedFood.getStatus()).thenReturn(STATUS.READY);

        orders.updateOrder(updatedFood);
        FastFood retrieved = orders.getOrder("Pizza");
        assertEquals(3, retrieved.getQuantity());
    }

    @Test
    void testGetTotalCost() {
        orders.addOrder(mockFood1); // 2 x $10.00
        orders.addOrder(mockFood2); // 1 x $5.00

        assertEquals(new BigDecimal("25.00"), orders.getTotalCost());
    }

    @Test
    void testGetMostRecentOrder() {
        orders.addOrder(mockFood1);
        orders.addOrder(mockFood2);

        assertEquals(mockFood1, orders.getMostRecentOrder());
    }

    @Test
    void testGetEarliestOrder() {
        orders.addOrder(mockFood1);
        orders.addOrder(mockFood2);

        assertEquals(mockFood2, orders.getEarliestOrder());
    }

    @Test
    void testClearOrders() {
        orders.addOrder(mockFood1);
        orders.addOrder(mockFood2);

        orders.clearOrders();
        assertTrue(orders.isEmpty());
        assertEquals(0, orders.getOrderCount());
    }

    @Test
    void testGetNonExistentOrder() {
        assertNull(orders.getOrder("NonExistent"));
    }
}
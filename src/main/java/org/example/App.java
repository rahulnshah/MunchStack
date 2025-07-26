package org.example;

import org.example.munchstack.impl.FastFoodOrders;
import org.example.munchstack.model.Drink;
import org.example.munchstack.model.FastFood;
import org.example.munchstack.model.Pizza;
import org.example.munchstack.service.OrdersList;

import java.math.BigDecimal;
import java.util.logging.Logger;

import static org.example.munchstack.enums.SIZE.MEDIUM;
import static org.example.munchstack.enums.STATUS.READY;

public class App {
    private static final Logger Logger = java.util.logging.Logger.getLogger(App.class);

    public static void main(String[] args) {

        FastFood pepperoniPizza = Pizza.builder().name("Pepperoni Pizza")
                .quantity(2)
                .price(new BigDecimal("15.99"))
                .diameter(new BigDecimal("12.0"))
                .topping("Pepperoni")
                .drizzle("Garlic Sauce")
                .cheese("Mozzarella")
                .build();

        FastFood cheeseBurger = FastFood.builder().name("Cheese Burger")
                .quantity(1)
                .price(new BigDecimal("8.99"))
                .status(READY)
                .build();

        FastFood chickenBurger = FastFood.builder().name("Chicken Burger")
                .quantity(3)
                .price(new BigDecimal("9.99"))
                .status(READY)
                .build();

        FastFood hawaiianPizza = Pizza.builder().name("Hawaiian Pizza")
                .quantity(1)
                .price(new BigDecimal("14.99"))
                .diameter(new BigDecimal("14.0"))
                .topping("Pineapple")
                .drizzle("Honey")
                .cheese("Cheddar")
                .build();

        FastFood mangoParadise = Drink.builder().name("Mango Paradise")
                .quantity(2)
                .price(new BigDecimal("5.99"))
                .size(MEDIUM)
                .status(READY)
                .build();

        OrdersList<FastFood> fastFoodOrders = new FastFoodOrders();
        fastFoodOrders.addOrder(pepperoniPizza);
        fastFoodOrders.addOrder(cheeseBurger);
        fastFoodOrders.addOrder(chickenBurger);
        fastFoodOrders.addOrder(hawaiianPizza);
        fastFoodOrders.addOrder(mangoParadise);
        ;
        System.out.println("Total Orders: " + fastFoodOrders.getOrderCount());
    }
}
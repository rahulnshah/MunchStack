package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.munchstack.impl.FastFoodOrders;
import org.example.munchstack.model.Burger;
import org.example.munchstack.model.Drink;
import org.example.munchstack.model.FastFood;
import org.example.munchstack.model.Pizza;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.example.munchstack.service.OrdersList;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static org.example.munchstack.enums.SIZE.MEDIUM;
import static org.example.munchstack.enums.STATUS.PENDING;
import static org.example.munchstack.enums.STATUS.READY;

public class App {
    private static final Logger Logger = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        objectMapper.setDateFormat(df);

        Logger.info("Welcome to MunchStack Fast Food Ordering System!");
        Logger.info("Initializing Fast Food Orders...");

        Date startTime = new Date();
        // Add hours, minutes, seconds
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);

        Logger.info("Start Time: {}", startTime);
        calendar.add(Calendar.HOUR, 1);
        FastFood pepperoniPizza = Pizza.builder().name("Pepperoni Pizza")
                .quantity(2)
                .price(new BigDecimal("15.99"))
                .diameter(new BigDecimal("12.0"))
                .topping("Pepperoni")
                .drizzle("Garlic Sauce")
                .cheese("Mozzarella")
                .status(PENDING)
                .createdAt(calendar.getTime()) // Adding 1 second to the start time for demonstration
                .build();

        calendar.add(Calendar.HOUR, 2);
        FastFood cheeseBurger = Burger.builder().name("Cheese Burger")
                .quantity(1)
                .price(new BigDecimal("8.99"))
                .status(READY)
                .createdAt(calendar.getTime())
                .build();

        calendar.add(Calendar.HOUR, 3);
        FastFood chickenBurger = Burger.builder().name("Chicken Burger")
                .quantity(3)
                .price(new BigDecimal("9.99"))
                .status(READY)
                .createdAt(calendar.getTime())
                .build();

        calendar.add(Calendar.HOUR, 4);
        FastFood hawaiianPizza = Pizza.builder().name("Hawaiian Pizza")
                .quantity(1)
                .price(new BigDecimal("14.99"))
                .diameter(new BigDecimal("14.0"))
                .topping("Pineapple")
                .drizzle("Honey")
                .cheese("Cheddar")
                .createdAt(calendar.getTime())
                .status(PENDING)
                .build();

        calendar.add(Calendar.HOUR, 5);
        FastFood mangoParadise = Drink.builder().name("Mango Paradise")
                .quantity(2)
                .price(new BigDecimal("5.99"))
                .size(MEDIUM)
                .status(READY)
                .createdAt(calendar.getTime())
                .build();

        Logger.info("Creating Fast Food Orders List...");

        OrdersList<FastFood> fastFoodOrders = new FastFoodOrders();
        fastFoodOrders.addOrder(pepperoniPizza);
        fastFoodOrders.addOrder(cheeseBurger);
        fastFoodOrders.addOrder(chickenBurger);
        fastFoodOrders.addOrder(hawaiianPizza);
        fastFoodOrders.addOrder(mangoParadise);

        // print the recent order using object mapper
        Logger.info("Recent Order: {}", objectMapper.writeValueAsString(fastFoodOrders.getRecentOrder()));
        // print the earliest order using object mapper
        Logger.info("Earliest Order: {}", objectMapper.writeValueAsString(fastFoodOrders.getEarliestOrder()));

        Logger.info("Total Orders: {}", fastFoodOrders.getOrderCount());
        Logger.info("Total Cost: ${}", fastFoodOrders.getTotalCost());
    }
}
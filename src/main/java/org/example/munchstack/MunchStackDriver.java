package org.example.munchstack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.munchstack.impl.FastFoodOrders;
import org.example.munchstack.model.Burger;
import org.example.munchstack.model.Drink;
import org.example.munchstack.model.FastFood;
import org.example.munchstack.model.Pizza;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.example.munchstack.service.OrdersList;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static org.example.munchstack.enums.SIZE.MEDIUM;
import static org.example.munchstack.enums.STATUS.PENDING;
import static org.example.munchstack.enums.STATUS.READY;

public class MunchStackDriver {
    private static final Logger Logger = LoggerFactory.getLogger(MunchStackDriver.class);


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Logger.info("Welcome to MunchStack Fast Food Ordering System!");
        Logger.info("Initializing Fast Food Orders...");

        LocalDate date = LocalDate.of(2025, Month.NOVEMBER, 25);

        Logger.info("Start Date: {}", date);
        date = date.plusWeeks(1);
        FastFood pepperoniPizza = Pizza.builder().name("Pepperoni Pizza")
                .quantity(2)
                .price(new BigDecimal("15.99"))
                .diameter(new BigDecimal("12.0"))
                .topping("Pepperoni")
                .drizzle("Garlic Sauce")
                .cheese("Mozzarella")
                .status(PENDING)
                .createdAt(date) // Adding 1 second to the start time for demonstration
                .build();

        date = date.plusWeeks(1);
        FastFood cheeseBurger = Burger.builder().name("Cheese Burger")
                .bun("Sesame")
                .patty("Black Bean")
                .quantity(1)
                .price(new BigDecimal("8.99"))
                .condiment("Ketchup")
                .status(READY)
                .createdAt(date)
                .build();

        date = date.plusWeeks(1);
        FastFood chickenBurger = Burger.builder().name("Chicken Burger")
                .bun("Whole Wheat")
                .patty("Grilled Chicken")
                .quantity(3)
                .price(new BigDecimal("9.99"))
                .condiment("Mayo")
                .status(READY)
                .createdAt(date)
                .build();

        date = date.plusWeeks(1);
        FastFood hawaiianPizza = Pizza.builder().name("Hawaiian Pizza")
                .quantity(1)
                .price(new BigDecimal("14.99"))
                .diameter(new BigDecimal("14.0"))
                .topping("Pineapple")
                .drizzle("Honey")
                .cheese("Cheddar")
                .createdAt(date)
                .status(PENDING)
                .build();

        date = date.plusWeeks(1);
        FastFood mangoParadise = Drink.builder().name("Mango Paradise")
                .quantity(2)
                .price(new BigDecimal("5.99"))
                .size(MEDIUM)
                .status(READY)
                .createdAt(date)
                .build();

        Logger.info("Creating Fast Food Orders List...");

        OrdersList<FastFood> fastFoodOrders = new FastFoodOrders();
        fastFoodOrders.addOrder(pepperoniPizza);
        fastFoodOrders.addOrder(cheeseBurger);
        fastFoodOrders.addOrder(chickenBurger);
        fastFoodOrders.addOrder(hawaiianPizza);
        fastFoodOrders.addOrder(mangoParadise);

        Logger.info("Listing All Orders:");
        fastFoodOrders.listOrders();
        // print the recent order using object mapper
        Logger.info("Recent Order: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fastFoodOrders.getMostRecentOrder()));
        // print the earliest order using object mapper
        Logger.info("Earliest Order: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fastFoodOrders.getEarliestOrder()));

        Logger.info("Total Orders: {}", fastFoodOrders.getOrderCount());
        Logger.info("Total Cost: ${}", fastFoodOrders.getTotalCost());
    }
}
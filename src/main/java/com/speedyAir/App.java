package com.speedyAir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.speedyAir.classes.Flight;
import com.speedyAir.classes.Order;
import com.speedyAir.utils.FlightParser;
import com.speedyAir.utils.JsonReader;
import com.speedyAir.utils.OrderParser;
import com.speedyAir.services.FlightService;
import com.speedyAir.services.OrderService;

public class App {
    private FlightService flightLoader;
    private OrderService orderLoader;

    public App(JsonReader jsonReader, FlightService flightLoader, OrderService orderLoader) {
        this.flightLoader = flightLoader;
        this.orderLoader = orderLoader;
    }

    public void run(String flightsFile, String ordersFile) {
        List<Flight> flights = new ArrayList<>();
        Map<String, List<Integer>> flightMap = new HashMap<>();
        flightLoader.loadFlights(flightsFile, flights, flightMap);

        List<Order> orders = new ArrayList<>();
        orderLoader.loadOrders(ordersFile, orders, flights, flightMap);

        flights.forEach(System.out::println);
        orders.forEach(System.out::println);
    }

    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        FlightParser flightParser = new FlightParser();
        FlightService flightLoader = new FlightService(jsonReader, flightParser);
        OrderParser orderParser = new OrderParser();
        OrderService orderLoader = new OrderService(jsonReader, orderParser);
        App app = new App(jsonReader, flightLoader, orderLoader);
        String flightsFile = "src/main/resources/flights.json";
        String ordersFile = "src/main/resources/orders.json";
        app.run(flightsFile, ordersFile);
    }
}

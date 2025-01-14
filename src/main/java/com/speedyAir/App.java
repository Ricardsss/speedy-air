package com.speedyAir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.speedyAir.classes.Flight;
import com.speedyAir.classes.Order;
import com.speedyAir.utils.JsonReader;
import com.speedyAir.utils.FlightLoader;
import com.speedyAir.utils.OrderLoader;

public class App {

    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        FlightLoader flightLoader = new FlightLoader();
        List<Flight> flights = new ArrayList<Flight>();
        HashMap<String, List<Integer>> flightMap = new HashMap<>();
        String flightsFile = "src/main/resources/flights.json";
        flightLoader.loadData(flightsFile, jsonReader, flights, flightMap);
        OrderLoader orderLoader = new OrderLoader();
        List<Order> orders = new ArrayList<Order>();
        String ordersFile = "src/main/resources/orders.json";
        orderLoader.loadOrders(ordersFile, jsonReader, orders, flights, flightMap);
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

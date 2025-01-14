package com.speedyAir.utils;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.speedyAir.classes.Flight;
import com.speedyAir.classes.Order;

public class OrderLoader {
  public void loadOrders(String ordersFile, JsonReader fileLoader, List<Order> orders, List<Flight> flights,
      HashMap<String, List<Integer>> flightMap) {
    JsonNode orderNode = fileLoader.loadJson(ordersFile);
    List<String> orderFieldNames = fileLoader.getFieldNames(orderNode);
    for (String fieldName : orderFieldNames) {
      JsonNode orderData = orderNode.get(fieldName);
      String destination = orderData.get("destination").toString();
      List<Integer> flightIndexes = flightMap.get(destination);
      if (flightIndexes != null) {
        Boolean orderCreated = false;
        for (Integer index : flightIndexes) {
          if (flights.get(index).hasSpace()) {
            flights.get(index).addBox();
            Order order = new Order(fieldName, flights.get(index));
            orders.add(order);
            orderCreated = true;
            break;
          }
        }
        if (!orderCreated) {
          Order order = new Order(fieldName);
          orders.add(order);
        }
      } else {
        Order order = new Order(fieldName);
        orders.add(order);
      }
    }
  }
}

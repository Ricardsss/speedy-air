package com.speedyAir.utils;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.speedyAir.classes.Flight;
import com.speedyAir.classes.Order;

public class OrderParser {
  public void parseOrders(JsonNode orderNode, List<String> orderNumbers, List<Order> orders) {
    for (String orderNumber : orderNumbers) {
      JsonNode orderData = orderNode.get(orderNumber);
      String destination = orderData.get("destination").toString();
      Order order = new Order(orderNumber, destination);
      orders.add(order);
    }
  }

  public void assignOrders(List<Order> orders, List<Flight> flights, Map<String, List<Integer>> flightMap) {
    for (Order order : orders) {
      String destination = order.getDestination();
      List<Integer> flightIndexes = flightMap.get(destination);
      if (flightIndexes != null) {
        for (Integer index : flightIndexes) {
          Flight flight = flights.get(index);
          if (flight.hasSpace()) {
            flight.addBox();
            order.setFlight(flight);
            break;
          }
        }
      }
    }
  }
}

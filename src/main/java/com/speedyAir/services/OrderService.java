package com.speedyAir.services;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.speedyAir.classes.Flight;
import com.speedyAir.classes.Order;
import com.speedyAir.utils.JsonReader;
import com.speedyAir.utils.OrderParser;

public class OrderService {

  private JsonReader jsonReader;
  private OrderParser orderParser;

  public OrderService(JsonReader jsonReader, OrderParser orderParser) {
    this.jsonReader = jsonReader;
    this.orderParser = orderParser;
  }

  public void loadOrders(String ordersFile, List<Order> orders, List<Flight> flights,
      Map<String, List<Integer>> flightMap) {
    JsonNode orderNode = this.jsonReader.loadJson(ordersFile);
    List<String> orderNumbers = this.jsonReader.getFieldNames(orderNode);
    this.orderParser.parseOrders(orderNode, orderNumbers, orders);
    this.orderParser.assignOrders(orders, flights, flightMap);
  }

}

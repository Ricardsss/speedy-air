package com.speedyAir.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.speedyAir.classes.Flight;

public class FlightParser {
  public void parseFlights(JsonNode flightNode, List<String> flightNumbers, List<Flight> flights) {
    for (String flightNumber : flightNumbers) {
      JsonNode flightData = flightNode.get(flightNumber);
      String origin = flightData.get("origin").toString();
      String destination = flightData.get("destination").toString();
      Integer day = Integer.parseInt(flightData.get("day").toString());
      Integer capacity = Integer.parseInt(flightData.get("capacity").toString());
      Flight flight = new Flight(flightNumber, origin, destination, day, capacity);
      flights.add(flight);
    }
  }

  public void populateFlightMap(List<Flight> flights, Map<String, List<Integer>> flightMap) {
    for (int i = 0; i < flights.size(); i++) {
      String destination = flights.get(i).getDestination();
      if (!flightMap.keySet().contains(destination)) {
        flightMap.put(destination, new ArrayList<>());
      }
      flightMap.get(destination).add(i);
    }
  }
}

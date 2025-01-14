package com.speedyAir.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.speedyAir.classes.Flight;

public class FlightLoader {
  public void loadData(String flightsFile, JsonReader jsonReader, List<Flight> flights,
      HashMap<String, List<Integer>> flightMap) {
    JsonNode flightNode = jsonReader.loadJson(flightsFile);
    List<String> flightFieldNames = jsonReader.getFieldNames(flightNode);
    for (String fieldName : flightFieldNames) {
      JsonNode flightData = flightNode.get(fieldName);
      Integer flightNumber = Integer.parseInt(fieldName);
      String origin = flightData.get("origin").toString();
      String destination = flightData.get("destination").toString();
      Integer day = Integer.parseInt(flightData.get("day").toString());
      Integer capacity = Integer.parseInt(flightData.get("capacity").toString());
      Flight flight = new Flight(flightNumber, origin, destination, day, capacity);
      flights.add(flight);
      if (!flightMap.keySet().contains(destination)) {
        flightMap.put(destination, new ArrayList<>());
      }
      flightMap.get(destination).add(flights.size() - 1);
    }
  }

}

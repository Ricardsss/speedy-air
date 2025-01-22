package com.speedyAir.services;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.speedyAir.classes.Flight;
import com.speedyAir.utils.FlightParser;
import com.speedyAir.utils.JsonReader;

public class FlightService {

  private JsonReader jsonReader;
  private FlightParser flightParser;

  public FlightService(JsonReader jsonReader, FlightParser flightParser) {
    this.flightParser = flightParser;
    this.jsonReader = jsonReader;
  }

  public void loadFlights(String flightsFile, List<Flight> flights, Map<String, List<Integer>> flightMap) {
    JsonNode flightNode = this.jsonReader.loadJson(flightsFile);
    List<String> flightNumbers = this.jsonReader.getFieldNames(flightNode);
    this.flightParser.parseFlights(flightNode, flightNumbers, flights);
    this.flightParser.populateFlightMap(flights, flightMap);
  }

}

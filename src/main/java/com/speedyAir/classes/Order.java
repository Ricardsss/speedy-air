package com.speedyAir.classes;

public class Order {
  private String orderNumber;
  private String destination;
  private Flight flight;

  public Order(String orderNumber, String destination) {
    this.orderNumber = orderNumber;
    this.destination = destination;
  }

  public String getDestination() {
    return this.destination;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  @Override
  public String toString() {
    if (this.flight == null) {
      return String.format("order: %s, flightNumber: not scheduled", this.orderNumber);
    }
    return String.format("order: %s, flightNumber: %s, departure: %s, arrival: %s, day: %d", this.orderNumber,
        this.flight.getFlightNumber(), this.flight.getOrigin(), this.destination, this.flight.getDay());
  }
}

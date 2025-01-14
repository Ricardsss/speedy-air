package com.speedyAir.classes;

public class Order {
  private String orderNumber;
  private Flight flight;

  public Order(String orderNumber) {
    this.orderNumber = orderNumber;
    this.flight = null;
  }

  public Order(String orderNumber, Flight flight) {
    this.orderNumber = orderNumber;
    this.flight = flight;
  }

  @Override
  public String toString() {
    if (this.flight == null) {
      return String.format("order: %s, flightNumber: not scheduled", this.orderNumber);
    }
    return String.format("order: %s, flightNumber: %d, departure: %s, arrival: %s, day: %d", this.orderNumber,
        this.flight.getFlightNumber(), this.flight.getOrigin(), this.flight.getDestination(), this.flight.getDay());
  }
}

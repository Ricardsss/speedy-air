package com.speedyAir.classes;

public class Flight {
  private String flightNumber;
  private String origin;
  private String destination;
  private Integer day;
  private Integer capacity;
  private Integer quantity;

  public Flight(String flightNumber, String origin, String destination, Integer day, Integer capacity) {
    this.flightNumber = flightNumber;
    this.origin = origin;
    this.destination = destination;
    this.day = day;
    this.capacity = capacity;
    this.quantity = 0;
  }

  public String getFlightNumber() {
    return this.flightNumber;
  }

  public String getOrigin() {
    return this.origin;
  }

  public String getDestination() {
    return this.destination;
  }

  public Integer getDay() {
    return this.day;
  }

  public Boolean hasSpace() {
    return this.quantity < this.capacity;
  }

  public void addBox() {
    this.quantity++;
  }

  @Override
  public String toString() {
    return String.format("Flight %s, departure: %s, arrival: %s, day: %d", this.flightNumber, this.origin,
        this.destination, this.day);
  }
}

package com.google.sps;

public final class Form {

  private final long id;
  private final String type;
  private final long date;
  private final double price;
  private final String zip;
  private final String description;
  private final String address;
  private final String state;
  private final long timestamp;

  public Form(long id, String type, long date, double price, String zip, String description, String address, String state, long timestamp) {
    this.id = id;
    this.type = type;
    this.date = date;
    this.price=price;
    this.zip = zip;
    this.description = description;
    this.address = address;
    this.state = state;
    this.timestamp = timestamp;
  }
}
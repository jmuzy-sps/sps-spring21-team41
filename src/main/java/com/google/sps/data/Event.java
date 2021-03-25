package com.google.sps.data;

import com.google.sps.data.Location;


/**
 * Event object for easy json packaing.
 */
public final class Event{

    private String type;
    private String details;
    private float price;
    private Location address;

    public Event(String type, String details, int price, Location address) {
        setType(type);
        setDetails(details);
        setPrice(price);
        setAddress(address);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public String getType() {
        return this.type;
    }

    public String getDetails() {
        return this.details;
    }

    public float getPrice() {
        return this.price;
    }

    public String getAddress() {
        return "" + address.getStreet() + ", " + address.getZipCode() + " " + address.getState();
    }

    public String getAddressStreet(){
        return address.getStreet();
    }

    public String getAddressState(){
        return address.getStreet();
    }
    public int getAddressZipCode(){
        return address.getZipCode();
    }
}

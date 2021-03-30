package com.google.sps.data;

import com.google.sps.data.Location;


/**
 * Event object for easy json packaing.
 */
public final class Event{

    private String type;
    private String details;
    private float price;
    private long date           // Epoch format
    public Location address;

    public Event(String type, String details, float price, long date, Location address) {
        setType(type);
        setDetails(details);
        setPrice(price);
        setDate(date);
        setAddress(address);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public void setDate(long date){
        this.date = date
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

    public long getDate(){
        return this.date;
    }
}

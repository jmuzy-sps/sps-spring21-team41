package com.google.sps.data;

import com.google.sps.data.Location;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Event object for easy json packaing.
 */
public final class Event{

    private String type;
    private String details;
    private double price;
    private long epoch;
    public Location address;

    public Event(String type, String details, double price, long epoch, Location address) {
        setType(type);
        setDetails(details);
        setPrice(price);
        setDate(epoch);
        setAddress(address);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public void setDate(long epoch){
        /**
         * 'date' is recieved and stored as epoch format (ex. 1617136856)
         */
        this.epoch = epoch;
    }

    public String getType() {
        return this.type;
    }

    public String getDetails() {
        return this.details;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDate(){
        /*
         * 'epoch' is returned as a human readable date string.
         */
        
        return new SimpleDateFormat("EEE, d MMM yyyy HH:mm").format(new Date (epoch*1000));
    }
}

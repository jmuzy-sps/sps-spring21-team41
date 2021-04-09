package com.google.sps.data;

import com.google.sps.data.Location;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Event object for easy json packaing.
 */
public final class Event{

    private String type;
    private String description;
    private double price;
    private String date;
    public Location address;

    public Event(String type, String description, double price, long epoch, Location address) {
        setType(type);
        setDescription(description);
        setPrice(price);
        setDate(epoch);
        setAddress(address);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public void setDate(long epoch){
        /*
         * 'date' is converted to human readable format.
         */
        
        this.date = new SimpleDateFormat("EEE, d MMM yyyy HH:mm").format(new Date (epoch*1000));
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDate() {
        return this.date;
    }
}

package com.google.sps.data;


/**
 * Event object for easy json packaing.
 */
public final class Event{

    private String type;
    private String details;
    private int price;

    public Event(String type, String details, int price){
        setType(type);
        setDetails(details);
        setPrice(price);
    }

    public void setType(String type){
        this.type = type;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getType(){
        return this.type;
    }

    public String getDetails(){
        return this.details;
    }

    public int getPrice(){
        return this.price;
    }
}

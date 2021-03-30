package com.google.sps.data;

/**
 * Location object for easy json packaing.
 */
public final class Location{

    private String street;
    private String state;
    private String zipCode;

    public  Location(String street, String state, String zipCode) {
        setState(state);
        setStreet(street);
        setZipCode(zipCode);
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getState() {
        return this.state;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}

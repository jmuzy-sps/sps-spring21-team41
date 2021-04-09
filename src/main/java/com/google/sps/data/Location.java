package com.google.sps.data;

/**
 * Location object for easy json packaing.
 */
public final class Location{

    private String address;
    private String state;
    private String zipCode;

    public  Location(String address, String state, String zipCode) {
        setState(state);
        setAddress(address);
        setZipCode(zipCode);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return this.address;
    }

    public String getState() {
        return this.state;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}

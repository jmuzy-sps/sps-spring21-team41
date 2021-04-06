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
        setaddress(address);
        setZipCode(zipCode);
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getaddress() {
        return this.address;
    }

    public String getState() {
        return this.state;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}

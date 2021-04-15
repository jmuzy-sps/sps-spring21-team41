package com.google.sps.data;

/**
 * Location object for easy json packaing.
 */
public final class Location{

    private String address;
    private String state;
    private String zipCode;
    private double latitude;
    private double longitude;

    public  Location(String address, String state, String zipCode, double latitude, double longitude) {
        this.setState(state);
        this.setAddress(address);
        this.setZipCode(zipCode);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
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

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}

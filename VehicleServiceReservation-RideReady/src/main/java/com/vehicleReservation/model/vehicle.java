package com.vehicleReservation.model;

public class vehicle {
    private int booking_id;
    private String date; //date
    private String time; //time
    private String location;
    private String vehicle_no;
    private int mileage;
    private String message; //text
    private String username;

    //generate constructor
    public vehicle(int booking_id, String date, String time, String location, String vehicle_no, int mileage, String message, String username) {
        this.booking_id = booking_id;
        this.date = date;
        this.time = time;
        this.location = location;
        this.vehicle_no = vehicle_no;
        this.mileage = mileage;
        this.message = message;
        this.username = username;
    }

//    public vehicle(){
//
//    }

    public vehicle(String date, String time, String location, String vehicle_no, int mileage, String message, String username) {
    }


    //generate getters and setters
    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
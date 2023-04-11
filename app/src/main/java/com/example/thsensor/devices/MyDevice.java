package com.example.thsensor.devices;

public class MyDevice {
    private String name, location;
    private final int id;

    public MyDevice(String name, String location, int id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    public boolean isHasMessage() {
        // need to describe this method
        // this method get a request to database
        // and find a messages
        return false;
    }


    // need to describe this class


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }
}

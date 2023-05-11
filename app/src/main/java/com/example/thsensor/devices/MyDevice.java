package com.example.thsensor.devices;

import java.util.ArrayList;

public class MyDevice {
    private String name, location;
    private final int id;
    private ArrayList<Notification> notifications;

    public MyDevice(String name, String location, int id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    protected boolean isHasMessage() {
        return this.notifications.isEmpty();
    }

    protected ArrayList<Notification> getMessages() {
        return this.notifications;
    }

    protected void updateMessages() {
        // ...server
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

    protected class Notification {
        private int deviceID;
        private String date, time;
        private String text;
    }
}

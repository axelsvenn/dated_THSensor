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

    public void clearMessages() {
        this.notifications.clear();
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

    public class Notification {
        private int deviceID = id;
        private String date, time;
        private String text;

        public Notification(String date, String time, String text) {
            this.date = date;
            this.time = time;
            this.text = text;
        }

        public int getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(int deviceID) {
            this.deviceID = deviceID;
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

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}

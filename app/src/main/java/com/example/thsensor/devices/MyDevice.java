package com.example.thsensor.devices;

import java.util.ArrayList;

public class MyDevice {
    private String name, location;
    private final int id;
    private ArrayList<Notification> notifications = new ArrayList<>();

    public MyDevice(String name, String location, int id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }

    protected boolean isHasMessage() {
        return this.notifications.isEmpty();
    }

    public ArrayList<Notification> getMessages() {
        return this.notifications;
    }

    public void clearMessages() {
        this.notifications.clear();
    }

    public void addMessage(String date, String time, String text) {
        this.notifications.add(new Notification(date, time, text));
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

    public String getIdString() {
        return "" + this.getId();
    }

    public void deleteMessage(Notification notification) {
        notifications.remove(notification);
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

        public String getDeviceIDString() {
            return "" + this.getDeviceID();
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

        public void deleteNotification() {
            deleteMessage(this);
        }
    }
}

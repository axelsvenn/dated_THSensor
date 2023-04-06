package com.example.thsensor.devices;

import java.util.ArrayList;

public class DataHelper {
    static DeviceProvider deviceProvider = new FakeDeviceProvider();

    public static ArrayList<MyDevice> getDevices() {

        // need to describe this class
        // decide about static or not this method
        return deviceProvider.getAll();
    }
}

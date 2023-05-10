package com.example.thsensor.devices;

import java.util.ArrayList;

public class FakeDeviceProvider implements DeviceProvider {

    @Override
    public ArrayList<MyDevice> selectAll() {
        ArrayList<MyDevice> devices = new ArrayList<>();

        devices.add(new MyDevice("qqq", "123.123.123", 15));
        devices.add(new MyDevice("www", "123.123.123", 16));
        devices.add(new MyDevice("eee", "123.123.123", 17));

        // create a database access
        // devices.add(new MyDevice(name, location, id));

        return devices;
    }
}

package com.example.thsensor.devices;

import java.util.ArrayList;

public class FakeDeviceProvider implements DeviceProvider {

    @Override
    public ArrayList<MyDevice> selectAll() {
        ArrayList<MyDevice> devices = new ArrayList<>();

        devices.add(new MyDevice("qqq", "123.123.123", 15));

        // create a database access
        // devices.add(new MyDevice(name, location, id));

        return devices;
    }
}

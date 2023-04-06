package com.example.thsensor.devices;

import java.util.ArrayList;

public class FakeDeviceProvider implements DeviceProvider {
    @Override
    public ArrayList<MyDevice> selectAll() {
        ArrayList<MyDevice> devices = new ArrayList<>();
        devices.add(new MyDevice());

        return devices;
    }
}

package com.example.thsensor.devices.provider;

import com.example.thsensor.devices.MyDevice;

import java.util.ArrayList;

public class FakeDeviceProvider implements DeviceProvider {
    @Override
    public ArrayList<MyDevice> selectAll() {

        ArrayList<MyDevice> devices = new ArrayList<>();

        devices.add(new MyDevice("qqq", "123.123.123", 15));
        devices.add(new MyDevice("www", "123.123.123", 16));
        devices.add(new MyDevice("eee", "123.123.123", 17));

        devices.get(0).addMessage("11.05.23", "12:00", "text");
        devices.get(0).addMessage("11.05.23", "12:00", "text2");
        devices.get(1).addMessage("11.05.23", "15:00", "text3");


        return devices;
    }
}

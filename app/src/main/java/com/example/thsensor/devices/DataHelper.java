package com.example.thsensor.devices;

import java.io.IOException;
import java.util.ArrayList;

public class DataHelper {
    static DeviceProvider deviceProvider;

    static {
        try {
            deviceProvider = new TempBluetoothDeviceProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<MyDevice> getDevices() {

        // need to describe this class
        // decide about static or not this method
        return deviceProvider.selectAll();
    }

    public static ArrayList<MyDevice.Notification> getAllMessages() {
        ArrayList<MyDevice.Notification> notifications = new ArrayList<>();
        for (MyDevice myDevice: DataHelper.getDevices()) notifications.addAll(myDevice.getMessages());

        return notifications;
    }

    public static void clearAllMessages() {
        for (MyDevice myDevice: DataHelper.getDevices()) myDevice.clearMessages();
    }
}

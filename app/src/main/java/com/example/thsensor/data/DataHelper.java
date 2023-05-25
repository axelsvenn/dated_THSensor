package com.example.thsensor.data;

import com.example.thsensor.data.provider.DeviceProvider;
import com.example.thsensor.data.provider.NotificationProvider;
import com.example.thsensor.data.provider.ServerDeviceProvider;
import com.example.thsensor.data.provider.ServerNotificationProvider;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private static DeviceProvider deviceProvider;
    private static NotificationProvider notificationProvider;

    static {
        deviceProvider = new ServerDeviceProvider();
        notificationProvider = new ServerNotificationProvider();
    }

    public static ArrayList<MyDevice> getDevices(ResponseHandler<List<MyDevice>> responseHandler) {
        return deviceProvider.selectAll(responseHandler);
    }

    public static ArrayList<MyDevice> getDevices() {
        return deviceProvider.selectAll(response -> {});
    }

    public static ArrayList<Notification> getAllNotifications(ResponseHandler<List<Notification>> responseHandler) {
        return notificationProvider.selectAll(responseHandler);
    }

    public static ArrayList<Notification> getAllNotifications() {
        return notificationProvider.selectAll(response -> {});
    }

    public static void clearAllNotifications() {
        for (MyDevice myDevice: DataHelper.getDevices()) myDevice.clearNotifications();
    }

    public static void deleteNotification() {

    }
}

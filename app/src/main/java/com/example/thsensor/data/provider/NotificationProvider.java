package com.example.thsensor.data.provider;

import com.example.thsensor.data.Notification;
import com.example.thsensor.data.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public interface NotificationProvider extends DataProvider<Notification> {
    @Override
    ArrayList<Notification> selectAll(ResponseHandler<List<Notification>> responseHandler);
}

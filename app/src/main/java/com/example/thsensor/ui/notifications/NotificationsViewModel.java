package com.example.thsensor.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thsensor.devices.MyDevice;

import java.util.ArrayList;

class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<MyDevice.Notification>> notifications;

    protected NotificationsViewModel() {
        notifications = new MutableLiveData<>();
    }

    public LiveData<ArrayList<MyDevice.Notification>> getMessages() {
        return notifications;
    }
}
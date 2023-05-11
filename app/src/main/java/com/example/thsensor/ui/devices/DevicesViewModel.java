package com.example.thsensor.ui.devices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.thsensor.devices.MyDevice;

import java.util.ArrayList;

class DevicesViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<MyDevice>> devices;

    protected DevicesViewModel() {
        devices = new MutableLiveData<>();
    }

    public LiveData<ArrayList<MyDevice>> getDevices() {
        return devices;
    }
}

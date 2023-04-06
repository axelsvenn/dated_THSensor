package com.example.thsensor.devices;

import java.util.ArrayList;

public interface DataProvider<T> {
    public ArrayList<T> getAll();
}

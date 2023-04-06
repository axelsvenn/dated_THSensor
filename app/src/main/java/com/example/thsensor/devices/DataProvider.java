package com.example.thsensor.devices;

import java.util.ArrayList;

public interface DataProvider<T> {
    ArrayList<T> selectAll();
}

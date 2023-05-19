package com.example.thsensor.devices.provider;

import java.util.ArrayList;

interface DataProvider<T> {
    ArrayList<T> selectAll();
}

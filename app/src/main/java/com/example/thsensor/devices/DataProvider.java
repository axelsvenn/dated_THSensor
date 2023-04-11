package com.example.thsensor.devices;

import java.util.ArrayList;

interface DataProvider<T> {
    ArrayList<T> selectAll();
}

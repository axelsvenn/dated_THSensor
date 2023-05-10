package com.example.thsensor.ui.devices;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thsensor.R;
import com.example.thsensor.devices.MyDevice;

import java.util.ArrayList;

class DevicesAdapter extends ArrayAdapter<MyDevice> {


    TextView id, name, location;
    Button clearNoti;

    protected DevicesAdapter(@NonNull Context context, ArrayList<MyDevice> devices) {
        super(context, R.layout.adapter_devices, devices);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_devices, parent, false);
        }

        id = convertView.findViewById(R.id.adapter_deviceID);
        name = convertView.findViewById(R.id.adapter_deviceName);
        location = convertView.findViewById(R.id.adapter_deviceLocation);
        clearNoti = convertView.findViewById(R.id.adapter_clearNotificationButton);

        MyDevice item = getItem(position);

        id.setText(getContext().getString(R.string.adapter_deviceID) + item.getId());
        name.setText(getContext().getString(R.string.adapter_deviceName) + item.getName());
        location.setText(getContext().getString(R.string.adapter_deviceLocation) + item.getLocation());
        clearNoti.setText(getContext().getString(R.string.adapter_deviceclearButton));


        // need to describe clearNoti

        return convertView;
    }
}

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

        id = convertView.findViewById(R.id.adapter_deviceID_info);
        name = convertView.findViewById(R.id.adapter_deviceName_info);
        location = convertView.findViewById(R.id.adapter_deviceLocation_info);
        clearNoti = convertView.findViewById(R.id.adapter_clearNotificationButton);

        MyDevice item = getItem(position);

        id.setText("" + item.getId());
        name.setText(item.getName());
        location.setText(item.getLocation());


        // need to describe clearNoti

        return convertView;
    }
}

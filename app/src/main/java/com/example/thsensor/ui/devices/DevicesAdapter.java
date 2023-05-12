package com.example.thsensor.ui.devices;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.thsensor.R;
import com.example.thsensor.devices.MyDevice;
import com.example.thsensor.ui.device.DeviceFragment;
import com.example.thsensor.ui.notifications.NotificationsFragment;

import java.util.ArrayList;

class DevicesAdapter extends ArrayAdapter<MyDevice> {

    FragmentActivity activity;
    TextView id, name, location;
    Button clearNoti, hideNoti;

    protected DevicesAdapter(FragmentActivity activity, @NonNull Context context, ArrayList<MyDevice> devices) {
        super(context, R.layout.adapter_devices, devices);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_devices, parent, false);
        }

        id = convertView.findViewById(R.id.deviceID_info);
        name = convertView.findViewById(R.id.deviceName_info);
        location = convertView.findViewById(R.id.deviceLocation_info);
        clearNoti = convertView.findViewById(R.id.device_clearNotificationButton);
        hideNoti = convertView.findViewById(R.id.device_hideNotificationButton);

        MyDevice item = getItem(position);

        id.setText(item.getIdString());
        name.setText(item.getName());
        location.setText(item.getLocation());

        clearNoti.setOnClickListener(v -> item.clearMessages());
        hideNoti.setOnClickListener(v -> {
            Fragment notificationsFragment = new NotificationsFragment(item);
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.nav_host_fragment_activity_main, notificationsFragment);
            // idk how to add fragment window

            transaction.commit();
        });

        return convertView;
    }
}
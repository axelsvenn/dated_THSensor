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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.thsensor.R;
import com.example.thsensor.devices.MyDevice;
import com.example.thsensor.ui.notifications.DialogClearNotificationsFragment;
import com.example.thsensor.ui.notifications.DialogNotificationsFragment;

import java.util.ArrayList;

class DevicesAdapter extends ArrayAdapter<MyDevice> {

    FragmentActivity activity;
    TextView id, name, location;
    Button clearNoti, hideNoti;
    FragmentManager childFragmentManager;

    public DevicesAdapter(DevicesFragment devicesFragment, ArrayList<MyDevice> devices) {
        super(devicesFragment.getContext(), R.layout.adapter_devices, devices);
        this.childFragmentManager = devicesFragment.getChildFragmentManager();
        this.activity = devicesFragment.getActivity();
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

        clearNoti.setOnClickListener(v -> {
            DialogClearNotificationsFragment dialog = new DialogClearNotificationsFragment(item);
            dialog.show(childFragmentManager, "custom");
        });

        hideNoti.setOnClickListener(v -> {
            DialogNotificationsFragment dialog = new DialogNotificationsFragment(item);
            dialog.show(childFragmentManager, "custom");
        });

        return convertView;
    }
}
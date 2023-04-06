package com.example.thsensor.ui.devices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.thsensor.databinding.FragmentDevicesBinding;
import com.example.thsensor.devices.DBDevices;
import com.example.thsensor.devices.MyDevice;

import java.util.ArrayList;


public class DevicesFragment extends Fragment {

    private FragmentDevicesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DevicesViewModel devicesViewModel =
                new ViewModelProvider(this).get(DevicesViewModel.class);

        binding = FragmentDevicesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView listView = binding.devicesListView;
        devicesViewModel.getDevices().observe(getViewLifecycleOwner(), myDevices -> {
            // describe mechanics of logging
        });

        ArrayAdapter<MyDevice> adapter = new DevicesAdapter(
                binding.getRoot().getContext(),
                DBDevices.getDevices()
        );

        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
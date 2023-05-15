package com.example.thsensor.ui.notifications;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thsensor.R;
import com.example.thsensor.databinding.FragmentNotificationsBinding;
import com.example.thsensor.devices.DataHelper;
import com.example.thsensor.devices.MyDevice;

public class NotificationsFragment extends DialogFragment {

    private FragmentNotificationsBinding binding;
    private MyDevice myDevice = null;

    public NotificationsFragment() { }

    public NotificationsFragment(MyDevice myDevice) {
        this.myDevice = myDevice;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView listView = binding.notificationsListView;
        notificationsViewModel.getMessages().observe(getViewLifecycleOwner(), myMessages -> {
            // describe mechanics of logging
        });

        ArrayAdapter<MyDevice.Notification> adapter = null;

        if (myDevice == null) adapter = new NotificationsAdapter(
                    binding.getRoot().getContext(),
                    DataHelper.getAllMessages()
            );
        else adapter = new NotificationsAdapter(
                    binding.getRoot().getContext(),
                    myDevice.getMessages()
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
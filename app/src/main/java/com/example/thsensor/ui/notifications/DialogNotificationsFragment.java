package com.example.thsensor.ui.notifications;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.thsensor.R;
import com.example.thsensor.devices.MyDevice;

public class DialogNotificationsFragment extends DialogFragment {

    MyDevice myDevice;

    public DialogNotificationsFragment(MyDevice myDevice) {
        this.myDevice = myDevice;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle(getResources().getText(R.string.dialog_title))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setView(R.layout.dialog_notifications)
                .setPositiveButton(getResources().getText(R.string.dialog_agree), (dialog, which) -> myDevice.clearMessages())
                .setNegativeButton(getResources().getText(R.string.dialog_disagree), null)
                .create();
    }

}

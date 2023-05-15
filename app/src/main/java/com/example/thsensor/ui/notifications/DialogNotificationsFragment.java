package com.example.thsensor.ui.notifications;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainerView;

import com.example.thsensor.R;
import com.example.thsensor.devices.MyDevice;

public class DialogNotificationsFragment extends DialogFragment {

    MyDevice myDevice;
    private View view;

    public DialogNotificationsFragment(MyDevice myDevice) {
        this.myDevice = myDevice;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        view = getLayoutInflater().inflate(R.layout.dialog_notifications, null);

        AlertDialog d = builder
                .setView(view)
                .setTitle(getResources().getText(R.string.dialog_title))
                .setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton(getResources().getText(R.string.dialog_agree), null)
                .setNegativeButton(getResources().getText(R.string.dialog_disagree), null)
                .create();


        //getChildFragmentManager().beginTransaction().add(R.id.fragmentContainerView, notificationsFragment).commit();

        return d;
    }

    @Override
    public void onResume() {
        super.onResume();
        ConstraintLayout fragmentContainerView = view.findViewById(R.id.fragmentContainerDialogNotifications);
        NotificationsFragment notificationsFragment = new NotificationsFragment(this.myDevice);
        getChildFragmentManager().beginTransaction().add(fragmentContainerView.getId(), notificationsFragment).commit();
    }
}

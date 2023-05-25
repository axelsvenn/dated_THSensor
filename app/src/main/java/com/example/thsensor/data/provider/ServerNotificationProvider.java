package com.example.thsensor.data.provider;

import com.example.thsensor.data.MyDevice;
import com.example.thsensor.data.Notification;
import com.example.thsensor.data.ResponseHandler;
import com.example.thsensor.server.RetroHelper;
import com.example.thsensor.server.helpers.MyCallback;
import com.example.thsensor.server.services.NotificationService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ServerNotificationProvider implements NotificationProvider {
    private Retrofit retrofit = RetroHelper.getServer();
    private NotificationService service = retrofit.create(NotificationService.class);
    private ArrayList<Notification> notifications = new ArrayList<>();

    @Override
    public ArrayList<Notification> selectAll(ResponseHandler<List<Notification>> responseHandler) {
        Call<List<Notification>> call = service.getNotifications();

        call.enqueue((MyCallback<List<Notification>>) (call1, response) -> {
            List<Notification> body = response.body();
            notifications.clear();

            notifications.addAll(body);
            responseHandler.process(notifications);
        });


        return notifications;
    }
}

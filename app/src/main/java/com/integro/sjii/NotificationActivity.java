package com.integro.sjii;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.sjii.adapter.NotificationsAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Notifications;
import com.integro.sjii.models.NotificationsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {

    Intent intent;
    Intent intent1;

    private static final String TAG = "NotificationActivity";
    private RecyclerView rvNotifications;
    private ArrayList<Notifications> notificationsArrayList;
    private NotificationsAdapter adapter;

    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

            rvNotifications = findViewById(R.id.rvNotifications);
            notificationsArrayList = new ArrayList<>();
            rvNotifications.setLayoutManager(new LinearLayoutManager(this));

            tag= (String) getIntent().getSerializableExtra("tag");

        getNotifications();
    }

    public void getNotifications() {
        Log.i(TAG, "getNotifications: "+tag);
        Call<NotificationsList> notificationsCall = ApiClients.getClients().create(ApiServices.class).getNotifications(tag);
        notificationsCall.enqueue(new Callback<NotificationsList>() {
            @Override
            public void onResponse(Call<NotificationsList> call, Response<NotificationsList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: fail");
                    return;
                }
                if (response.body().getNotificationsArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }
                int size = response.body().getNotificationsArrayList().size();
                for (int i = 0; i < size; i++) {
                    notificationsArrayList.add(response.body().getNotificationsArrayList().get(i));
                }
                adapter=new NotificationsAdapter(getApplicationContext(),notificationsArrayList);
                rvNotifications.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NotificationsList> call, Throwable t) {

            }
        });
    }
}

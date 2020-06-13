package com.integro.sjii.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.integro.sjii.R;
import com.integro.sjii.adapter.NotificationsAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Notifications;
import com.integro.sjii.models.NotificationsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsFragment extends Fragment {

    private static final String TAG = "NotificationsFragment";

    private RecyclerView rvNotifications;
    private ArrayList<Notifications> notificationsArrayList;
    private NotificationsAdapter adapter;
    String tag = "tag";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        rvNotifications = view.findViewById(R.id.rvNotifications);
        notificationsArrayList = new ArrayList<>();
        rvNotifications.setLayoutManager(new LinearLayoutManager(getContext()));
        tag = (String) getActivity().getIntent().getSerializableExtra("tag");
        getNotifications();
        return view;
    }


    public void getNotifications() {
        Log.i(TAG, "getNotifications: " + tag);
        Call<NotificationsList> notificationsCall = ApiClients.getClients().create(ApiServices.class).getNotifications("NOTIFICATIONS");
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
                adapter = new NotificationsAdapter(getContext(), notificationsArrayList);
                rvNotifications.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NotificationsList> call, Throwable t) {

            }
        });
    }
}

package com.integro.sjii;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.sjii.adapter.AnnouncementsAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.AnnouncementList;
import com.integro.sjii.models.Announcements;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnouncementsActivity extends AppCompatActivity {

    private static final String TAG = "AnnouncementsActivity";
    private RecyclerView rvAnnouncement;
    private ArrayList<Announcements> announcementsArrayList;
    private AnnouncementsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        rvAnnouncement = findViewById(R.id.rvAnnouncement);
        announcementsArrayList = new ArrayList<>();
        rvAnnouncement.setLayoutManager(new LinearLayoutManager(this));
        getAnnouncements();
    }

    public void getAnnouncements() {
        Call<AnnouncementList> announcementListCall = ApiClients.getClients().create(ApiServices.class).getAnnouncementList();
        announcementListCall.enqueue(new Callback<AnnouncementList>() {
            @Override
            public void onResponse(Call<AnnouncementList> call, Response<AnnouncementList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: fail");
                    return;
                }
                if (response.body().getAnnouncementsArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }

                int size = response.body().getAnnouncementsArrayList().size();
                for (int i = 0; i < size; i++) {
                    announcementsArrayList.add(response.body().getAnnouncementsArrayList().get(i));
                }
                adapter = new AnnouncementsAdapter(getApplicationContext(), announcementsArrayList);
                rvAnnouncement.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AnnouncementList> call, Throwable t) {

            }
        });
    }
}

package com.integro.sjii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.integro.sjii.adapter.ManagementAdapter;
import com.integro.sjii.adapter.NewsLetterAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Management;
import com.integro.sjii.models.ManagementList;
import com.integro.sjii.models.NewsLetter;
import com.integro.sjii.models.NewsLetterList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagementActivity extends AppCompatActivity {
    private RecyclerView rvManagement;
    private ArrayList<Management> managementArrayList;
    private ManagementAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        rvManagement = findViewById(R.id.rvManagements);
        managementArrayList = new ArrayList<>();
        rvManagement.setLayoutManager(new LinearLayoutManager(this));
        getManagement();
    }

    public void getManagement() {
        Call<ManagementList> newsLetterListCall = ApiClients.getClients().create(ApiServices.class).getManagementList();
        newsLetterListCall.enqueue(new Callback<ManagementList>() {
            @Override
            public void onResponse(Call<ManagementList> call, Response<ManagementList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getManagementArrayList() == null) {
                    return;
                }
                int size = response.body().getManagementArrayList().size();
                for (int i = 0; i < size; i++) {
                    managementArrayList.add(response.body().getManagementArrayList().get(i));
                }
                adapter = new ManagementAdapter(getApplicationContext(), managementArrayList);
                rvManagement.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ManagementList> call, Throwable t) {

            }
        });
    }
}

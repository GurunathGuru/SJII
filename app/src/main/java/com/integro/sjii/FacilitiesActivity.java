package com.integro.sjii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.integro.sjii.adapter.FacilitiesAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Facilities;
import com.integro.sjii.models.FacilitiesList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacilitiesActivity extends AppCompatActivity {

    private RecyclerView rvFacilities;
    private ArrayList<Facilities> facilitiesArrayList;
    private FacilitiesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);

        facilitiesArrayList = new ArrayList<>();
        rvFacilities = findViewById(R.id.rvFacilities);

        getFacilitiesList();
    }

    private void getFacilitiesList() {
        Call<FacilitiesList> facilitiesListCall = ApiClients.getClients().create(ApiServices.class).getFacilitiesList();
        facilitiesListCall.enqueue(new Callback<FacilitiesList>() {
            @Override
            public void onResponse(Call<FacilitiesList> call, Response<FacilitiesList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getFacilitiesArrayList() == null) {
                    return;
                }
                int size = response.body().getFacilitiesArrayList().size();
                for (int i = 0; i < size; i++) {
                    facilitiesArrayList.add(response.body().getFacilitiesArrayList().get(i));
                }
                rvFacilities.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter=new FacilitiesAdapter(getApplicationContext(),facilitiesArrayList);
                rvFacilities.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FacilitiesList> call, Throwable t) {

            }
        });
    }
}

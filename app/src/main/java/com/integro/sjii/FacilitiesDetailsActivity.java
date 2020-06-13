package com.integro.sjii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.integro.sjii.adapter.FacilitiesAdapter;
import com.integro.sjii.adapter.FacilitiesImageAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Facilities;
import com.integro.sjii.models.FacilityImages;
import com.integro.sjii.models.FacilityImagesList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacilitiesDetailsActivity extends AppCompatActivity {

    String itemId;
    int position;

    private RecyclerView  rvFacilitiesImages;
    private ArrayList<FacilityImages> facilityImagesArrayList;
    private FacilitiesImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_details);

        itemId= (String) getIntent().getSerializableExtra("DATA");
        position= (int) getIntent().getSerializableExtra("position");

        rvFacilitiesImages=findViewById(R.id.rvFacilitiesImages);
        facilityImagesArrayList=new ArrayList<>();

        getFacilitiesList();
    }

    private void getFacilitiesList() {
        Call<FacilityImagesList> facilityImagesListCall= ApiClients.getClients().create(ApiServices.class).getFacilityImagesList(itemId);
        facilityImagesListCall.enqueue(new Callback<FacilityImagesList>() {
            @Override
            public void onResponse(Call<FacilityImagesList> call, Response<FacilityImagesList> response) {
                if (!response.isSuccessful()){
                    return;
                }
                if (response.body().getFacilityImagesArrayList()==null){
                    return;
                }
                int size=response.body().getFacilityImagesArrayList().size();
                for (int i=0; i<size;i++){
                    facilityImagesArrayList.add(response.body().getFacilityImagesArrayList().get(i));
                }
                rvFacilitiesImages.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                adapter=new FacilitiesImageAdapter(getApplicationContext(),facilityImagesArrayList);
                rvFacilitiesImages.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FacilityImagesList> call, Throwable t) {

            }
        });
    }
}

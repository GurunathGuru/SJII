package com.integro.sjii;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.sjii.adapter.FacultyAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Faculty;
import com.integro.sjii.models.FacultyList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FacultyActivity extends AppCompatActivity {

    private static final String TAG = "FacultyActivity";
    private RecyclerView rvFaculty;
    private ArrayList<Faculty> facultyArrayList;
    private FacultyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        rvFaculty = findViewById(R.id.rvFaculty);
        facultyArrayList = new ArrayList<>();
        rvFaculty.setLayoutManager(new LinearLayoutManager(this));

        getFacultyList();
    }

    public void getFacultyList() {
        Call<FacultyList> facultyListCall = ApiClients.getClients().create(ApiServices.class).getFacultyList();
        facultyListCall.enqueue(new Callback<FacultyList>() {
            @Override
            public void onResponse(Call<FacultyList> call, Response<FacultyList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: fail");
                    return;
                }
                if (response.body().getFacultyArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }

                int size = response.body().getFacultyArrayList().size();
                for (int i = 0; i < size; i++) {
                    facultyArrayList.add(response.body().getFacultyArrayList().get(i));
                }
                adapter = new FacultyAdapter(getApplicationContext(), facultyArrayList);
                rvFaculty.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FacultyList> call, Throwable t) {

            }
        });
    }
}

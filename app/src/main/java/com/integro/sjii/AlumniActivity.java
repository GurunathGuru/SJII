package com.integro.sjii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.integro.sjii.adapter.AlumniAdapter;
import com.integro.sjii.adapter.FacultyAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Alumni;
import com.integro.sjii.models.AlumniList;
import com.integro.sjii.models.Faculty;
import com.integro.sjii.models.FacultyList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumniActivity extends AppCompatActivity {

    private static final String TAG = "AlumniActivity";
    private RecyclerView rvAlumni;
    private ArrayList<Alumni> alumniArrayList;
    private AlumniAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni);

        TextView alumniRegistration = findViewById(R.id.alumniRegistration);

        alumniRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="http://sjiialumni.com/registration.php";
                Intent intent=new Intent(getApplicationContext(),WebActivity.class);
                intent.putExtra("TAG",url);
                startActivity(intent);
            }
        });

        rvAlumni = findViewById(R.id.rvAlumni);
        alumniArrayList = new ArrayList<>();
        rvAlumni.setLayoutManager(new LinearLayoutManager(this));

        getAlumniList();
    }


    public void getAlumniList() {
        Call<AlumniList> alumniListCall = ApiClients.getClients().create(ApiServices.class).getAlumniList();
        alumniListCall.enqueue(new Callback<AlumniList>() {
            @Override
            public void onResponse(Call<AlumniList> call, Response<AlumniList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: fail");
                    return;
                }
                if (response.body().getAlumniArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }

                int size = response.body().getAlumniArrayList().size();
                for (int i = 0; i < size; i++) {
                    alumniArrayList.add(response.body().getAlumniArrayList().get(i));
                }
                adapter = new AlumniAdapter(getApplicationContext(), alumniArrayList);
                rvAlumni.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AlumniList> call, Throwable t) {

            }
        });
    }
}

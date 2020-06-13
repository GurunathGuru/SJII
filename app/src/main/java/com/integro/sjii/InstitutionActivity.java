package com.integro.sjii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.integro.sjii.adapter.InstitutionAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Institution;
import com.integro.sjii.models.InstitutionList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InstitutionActivity extends AppCompatActivity {
    private static final String TAG = "InstitutionActivity";
    private RecyclerView rvInstitution;
    private InstitutionAdapter adapter;
    private ArrayList<Institution> institutionArrayList;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution);

        institutionArrayList = new ArrayList<>();
        rvInstitution = findViewById(R.id.rvInstitution);
        manager = new LinearLayoutManager(this);
        rvInstitution.setLayoutManager(manager);
        getInstitutionList();
    }

    private void getInstitutionList() {
        Call<InstitutionList> institutionListCall = ApiClients.getClients().create(ApiServices.class).getInstitutionsList();
        institutionListCall.enqueue(new Callback<InstitutionList>() {
            @Override
            public void onResponse(Call<InstitutionList> call, Response<InstitutionList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getInstitutionArrayList() == null) {
                    return;
                }
                int size = response.body().getInstitutionArrayList().size();
                Log.i(TAG, "onResponse: "+size);
                for (int i = 0; i < size; i++) {
                    institutionArrayList.add(response.body().getInstitutionArrayList().get(i));
                }
                adapter = new InstitutionAdapter(getApplicationContext(), institutionArrayList);
                rvInstitution.setLayoutManager(manager);
                rvInstitution.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<InstitutionList> call, Throwable t) {

            }
        });
    }
}

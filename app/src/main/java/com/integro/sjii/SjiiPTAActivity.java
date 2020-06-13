package com.integro.sjii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.integro.sjii.adapter.NewsLetterAdapter;
import com.integro.sjii.adapter.SjiiPTAAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.NewsLetter;
import com.integro.sjii.models.NewsLetterList;
import com.integro.sjii.models.SjiiPTA;
import com.integro.sjii.models.SjiiPTAList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SjiiPTAActivity extends AppCompatActivity {

    private RecyclerView rvPta;
    private ArrayList<SjiiPTA> sjiiPTAArrayList;
    private SjiiPTAAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjii_p_t_a);

        rvPta = findViewById(R.id.rvPta);
        sjiiPTAArrayList = new ArrayList<>();
        rvPta.setLayoutManager(new LinearLayoutManager(this));
        getPta();
    }
    public void getPta() {
        Call<SjiiPTAList> ptaListCall = ApiClients.getClients().create(ApiServices.class).getSjiiPTAList();
        ptaListCall.enqueue(new Callback<SjiiPTAList>() {
            @Override
            public void onResponse(Call<SjiiPTAList> call, Response<SjiiPTAList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getSjiiPTAArrayList() == null) {
                    return;
                }
                int size = response.body().getSjiiPTAArrayList().size();
                for (int i = 0; i < size; i++) {
                    sjiiPTAArrayList.add(response.body().getSjiiPTAArrayList().get(i));
                }
                adapter = new SjiiPTAAdapter(getApplicationContext(), sjiiPTAArrayList);
                rvPta.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SjiiPTAList> call, Throwable t) {

            }
        });
    }
}

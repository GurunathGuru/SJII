package com.integro.sjii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.integro.sjii.adapter.PrincipalMsgAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.Principalmsg;
import com.integro.sjii.models.PrincipalmsgList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalMsgActivity extends AppCompatActivity {

    private static final String TAG = "PrincipalMsgActivity";
    private RecyclerView rvPrincipalMsg;
    private ArrayList<Principalmsg> principalmsgArrayList;
    private PrincipalMsgAdapter adapter;
    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_msg);

        tag= (String) getIntent().getSerializableExtra("tag");

        rvPrincipalMsg = findViewById(R.id.rvPrincipalMsg);
        principalmsgArrayList = new ArrayList<>();
        rvPrincipalMsg.setLayoutManager(new LinearLayoutManager(this));

        getPrinciMesg();
    }

    public void getPrinciMesg() {
        Log.i(TAG, "getPrinciMesg: "+tag);
        Call<PrincipalmsgList> listCall = ApiClients.getClients().create(ApiServices.class).getPrincipalmsgList(tag);
        listCall.enqueue(new Callback<PrincipalmsgList>() {

            @Override
            public void onResponse(Call<PrincipalmsgList> call, Response<PrincipalmsgList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: fial");
                    return;
                }
                if (response.body().getPrincipalmsgArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }
                int size = response.body().getPrincipalmsgArrayList().size();
                Log.i(TAG, "onResponse: guru "+response.body());
                for (int i = 0; i < size; i++) {
                    principalmsgArrayList.add(response.body().getPrincipalmsgArrayList().get(i));
                }
                adapter=new PrincipalMsgAdapter(getApplicationContext(),principalmsgArrayList);
                rvPrincipalMsg.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PrincipalmsgList> call, Throwable t) {

            }
        });
    }
}

package com.integro.sjii;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.integro.sjii.adapter.NewsAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.News;
import com.integro.sjii.models.NewsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    private static final String TAG = "NewsActivity";
    private RecyclerView rvNews;
    private ArrayList<News> newsArrayList;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        rvNews = findViewById(R.id.rvNews);
        newsArrayList = new ArrayList();
        rvNews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        getNews();
    }

    public void getNews() {
        Call<NewsList> newsListCall = ApiClients.getClients().create(ApiServices.class).getNewsList();
        newsListCall.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: fail");
                    return;
                }
                if (response.body().getNewsArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }
                int size = response.body().getNewsArrayList().size();
                for (int i = 0; i < size; i++) {
                    newsArrayList.add(response.body().getNewsArrayList().get(i));
                }
                adapter = new NewsAdapter(getApplicationContext(), newsArrayList);
                rvNews.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

            }
        });
    }
}

package com.integro.sjii.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.integro.sjii.R;
import com.integro.sjii.adapter.NewsAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.News;
import com.integro.sjii.models.NewsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    private static final String TAG = "NewsFragment";
    private RecyclerView rvNews;
    private ArrayList<News> newsArrayList;
    private NewsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        rvNews = view.findViewById(R.id.rvNews);
        newsArrayList = new ArrayList();
        rvNews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        getNews();
        return view;
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
                adapter = new NewsAdapter(getContext(), newsArrayList);
                rvNews.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

            }
        });
    }
}

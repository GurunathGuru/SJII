package com.integro.sjii;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.demono.AutoScrollViewPager;
import com.integro.sjii.adapter.NewsImagesAdapter;
import com.integro.sjii.apis.ApiClients;
import com.integro.sjii.apis.ApiServices;
import com.integro.sjii.models.News;
import com.integro.sjii.models.NewsImages;
import com.integro.sjii.models.NewsImagesList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsDetailActivity extends AppCompatActivity {

    private static final String TAG = "NewsDetailActivity";
    private AutoScrollViewPager vpNewsImages;
    private ImageView ivImage;
    private ArrayList<NewsImages> newsImagesArrayList;
    private NewsImagesAdapter adapter;
    private String newsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        newsImagesArrayList = new ArrayList<>();
        vpNewsImages = findViewById(R.id.vpNewsImages);

        News news = (News) getIntent().getSerializableExtra("DATA");
        newsId = news.getId();

        ivImage = findViewById(R.id.ivImage);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvShare=findViewById(R.id.tvShare);
        Glide.with(getApplicationContext())
                .load(news.getImage())
                .into(ivImage);

        tvDate.setText(news.getDate());
        tvTitle.setText(news.getTitle());
        tvDescription.setText(news.getDescription());

        tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((Intent.ACTION_SEND));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"http://sjiibangalore.com/sjii_app/newsshare.php?id="+newsId);
                startActivity(intent);
            }
        });
        getNewsImages();
    }

    public void getNewsImages() {
        Call<NewsImagesList> newsImagesListCall = ApiClients.getClients().create(ApiServices.class).getNewsImagesList(newsId);
        newsImagesListCall.enqueue(new Callback<NewsImagesList>() {
            @Override
            public void onResponse(Call<NewsImagesList> call, Response<NewsImagesList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: fail");
                    return;
                }
                if (response.body().getNewsImagesArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }

                int size = response.body().getNewsImagesArrayList().size();
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        newsImagesArrayList.add(response.body().getNewsImagesArrayList().get(i));
                    }
                    adapter = new NewsImagesAdapter(getApplicationContext(), newsImagesArrayList);
                    vpNewsImages.setAdapter(adapter);
                    vpNewsImages.startAutoScroll(3000);
                } else {
                    vpNewsImages.setVisibility(View.GONE);
                    ivImage.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<NewsImagesList> call, Throwable t) {

            }
        });
    }
}

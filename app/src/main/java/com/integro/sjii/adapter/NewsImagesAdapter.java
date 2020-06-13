package com.integro.sjii.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.integro.sjii.R;
import com.integro.sjii.models.NewsImages;

import java.util.ArrayList;

public class NewsImagesAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<NewsImages> newsImagesArrayList;

    public NewsImagesAdapter(Context context, ArrayList<NewsImages> newsImagesArrayList) {
        this.context = context;
        this.newsImagesArrayList = newsImagesArrayList;
    }

    @Override
    public int getCount() {
        return newsImagesArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView ivImage;

        View view = LayoutInflater.from(context).inflate(R.layout.card_cover_photos, container, false);

        ivImage = view.findViewById(R.id.ivImage);

        Glide.with(context)
                .load(newsImagesArrayList.get(position).getImage())
                .into(ivImage);

        ((ViewPager) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}

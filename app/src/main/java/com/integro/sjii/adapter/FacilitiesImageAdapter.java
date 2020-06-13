package com.integro.sjii.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.sjii.R;
import com.integro.sjii.models.FacilityImages;

import java.util.ArrayList;

public class FacilitiesImageAdapter extends RecyclerView.Adapter<FacilitiesImageAdapter.MyViewHolder> {
    Context context;
    ArrayList<FacilityImages> facilityImagesArrayList;
    public FacilitiesImageAdapter(Context context, ArrayList<FacilityImages> facilityImagesArrayList) {
        this.context=context;
        this.facilityImagesArrayList=facilityImagesArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.card_facilities_images,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FacilityImages facilityImages=facilityImagesArrayList.get(position);

        Glide.with(context)
                .load(facilityImages.getImage())
                .into(holder.ivImage);

    }


    @Override
    public int getItemCount() {
        return facilityImagesArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage=itemView.findViewById(R.id.ivImage);
        }
    }
}

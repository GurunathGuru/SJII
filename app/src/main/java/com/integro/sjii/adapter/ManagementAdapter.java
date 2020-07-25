package com.integro.sjii.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.sjii.R;
import com.integro.sjii.models.Management;
import com.integro.sjii.models.SjiiPTA;

import java.util.ArrayList;

public class ManagementAdapter extends RecyclerView.Adapter<ManagementAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Management> managementArrayList;

    public ManagementAdapter(Context context, ArrayList<Management> managementArrayList) {
        this.context = context;
        this.managementArrayList = managementArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_pta, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Management management = managementArrayList.get(position);

        Glide.with(context)
                .load(management.getImage())
                .into(holder.ivImage);

        holder.tvTitle.setText(management.getName());
        holder.tvDescription.setText(management.getDesignation());
    }

    @Override
    public int getItemCount() {
        return managementArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvDescription;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}

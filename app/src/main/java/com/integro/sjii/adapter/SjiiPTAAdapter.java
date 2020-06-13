package com.integro.sjii.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.sjii.R;
import com.integro.sjii.models.SjiiPTA;

import java.util.ArrayList;

public class SjiiPTAAdapter extends RecyclerView.Adapter<SjiiPTAAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<SjiiPTA>sjiiPTAArrayList;

    public SjiiPTAAdapter(Context context, ArrayList<SjiiPTA> sjiiPTAArrayList) {
        this.context=context;
        this.sjiiPTAArrayList=sjiiPTAArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_pta, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SjiiPTA sjiiPTA = sjiiPTAArrayList.get(position);

        Glide.with(context)
                .load(sjiiPTA.getImage())
                .into(holder.ivImage);

        holder.tvTitle.setText(sjiiPTA.getName());
        holder.tvDescription.setText(sjiiPTA.getDesignation());
        holder.tvPosition.setText(sjiiPTA.getDesignation());
    }

    @Override
    public int getItemCount() {
        return sjiiPTAArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvPosition;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPosition = itemView.findViewById(R.id.tvPosition);
        }
    }
}

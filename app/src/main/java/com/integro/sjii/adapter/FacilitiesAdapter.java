package com.integro.sjii.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.sjii.FacilitiesDetailsActivity;
import com.integro.sjii.R;
import com.integro.sjii.models.Facilities;

import java.util.ArrayList;

public class FacilitiesAdapter extends RecyclerView.Adapter<FacilitiesAdapter.MyViewHolder> {

    Context context;
    ArrayList<Facilities>facilitiesArrayList;

    public FacilitiesAdapter(Context context, ArrayList<Facilities> facilitiesArrayList) {
        this.context=context;
        this.facilitiesArrayList=facilitiesArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_facililies,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Facilities facilities=facilitiesArrayList.get(position);

        Glide.with(context).load(facilities.getImage()).into(holder.ivImage);
        holder.tvTitle.setText(facilities.getTitle());
        holder.tvDescription.setText(facilities.getDescription());

        holder.cardNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, FacilitiesDetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("DATA",facilities.getId());
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return facilitiesArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvTitle;
        TextView tvDescription;
        CardView cardNews;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage=itemView.findViewById(R.id.ivImage);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            cardNews=itemView.findViewById(R.id.cardNews);
        }
    }
}

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
import com.integro.sjii.models.Alumni;
import com.integro.sjii.models.SjiiPTA;

import java.util.ArrayList;

public class AlumniAdapter extends RecyclerView.Adapter<AlumniAdapter.MyViewHolder> {
    Context context;
    ArrayList<Alumni> alumniArrayList;

    public AlumniAdapter(Context context, ArrayList<Alumni> alumniArrayList) {
    this.context=context;
    this.alumniArrayList=alumniArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_pta,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Alumni alumni = alumniArrayList.get(position);

        Glide.with(context)
                .load(alumni.getImage())
                .into(holder.ivImage);

        holder.tvTitle.setText(alumni.getName());
        holder.tvDescription.setText("Batch: "+alumni.getBatch());
        holder.tvPosition.setText(alumni.getPosition());

    }

    @Override
    public int getItemCount() {
        return alumniArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvPosition;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPosition = itemView.findViewById(R.id.tvPosition);

        }
    }
}

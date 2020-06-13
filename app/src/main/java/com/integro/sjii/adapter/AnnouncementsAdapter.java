package com.integro.sjii.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.sjii.R;
import com.integro.sjii.models.Announcements;

import java.util.ArrayList;

public class AnnouncementsAdapter extends RecyclerView.Adapter<AnnouncementsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Announcements> announcementsArrayList;

    public AnnouncementsAdapter(Context context, ArrayList<Announcements> announcementsArrayList) {
        this.context = context;
        this.announcementsArrayList = announcementsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_notifications, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Announcements announcements = announcementsArrayList.get(position);
        holder.tvDate.setText(announcements.getDate());
        holder.tvTitle.setText(announcements.getTitle());
        holder.tvDescription.setText(announcements.getPdf());
        holder.tvDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse(announcements.getPdf()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return announcementsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate;
        private TextView tvTitle;
        private TextView tvDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}

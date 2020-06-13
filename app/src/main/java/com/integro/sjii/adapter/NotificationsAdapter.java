package com.integro.sjii.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.sjii.R;
import com.integro.sjii.models.Notifications;

import java.util.ArrayList;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Notifications> notificationsArrayList;

    private static final String TAG = "NotificationsAdapter";

    public NotificationsAdapter(Context context, ArrayList<Notifications> notificationsArrayList) {
        this.context = context;
        this.notificationsArrayList = notificationsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_notifications, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Notifications notifications = notificationsArrayList.get(position);

        Log.i(TAG, "onBindViewHolder: " + notifications.getDate());

        holder.tvDate.setText(notifications.getDate());
        holder.tvTitle.setText(notifications.getTitle());
        holder.tvDescription.setText(notifications.getDescription());
    }

    @Override
    public int getItemCount() {
        return notificationsArrayList.size();
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

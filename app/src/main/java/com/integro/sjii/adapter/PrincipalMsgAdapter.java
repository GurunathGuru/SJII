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
import com.integro.sjii.models.Principalmsg;

import java.util.ArrayList;

public class PrincipalMsgAdapter extends RecyclerView.Adapter<PrincipalMsgAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Principalmsg> principalmsgArrayList;

    public PrincipalMsgAdapter(Context context, ArrayList<Principalmsg> principalmsgArrayList) {
        this.context = context;
        this.principalmsgArrayList = principalmsgArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_principal_message, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Principalmsg principalmsg = principalmsgArrayList.get(position);

        Glide.with(context)
                .load(principalmsg.getImage())
                .into(holder.ivImage);

        holder.tvTitle.setText(principalmsg.getName());
        holder.tvDescription.setText(principalmsg.getDescription());
        holder.tvDesignation.setText(principalmsg.getDesignation());

    }

    @Override
    public int getItemCount() {
        return principalmsgArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvDesignation;
        private TextView tvDescription;
        private ImageView ivImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvDesignation=itemView.findViewById(R.id.tvDesignation);

        }
    }
}

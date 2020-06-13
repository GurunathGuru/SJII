package com.integro.sjii.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.sjii.R;
import com.integro.sjii.WebActivity;
import com.integro.sjii.models.Institution;
import com.integro.sjii.models.News;

import java.util.ArrayList;

public class InstitutionAdapter extends RecyclerView.Adapter<InstitutionAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Institution> institutionArrayList;

    public InstitutionAdapter(Context context, ArrayList<Institution> institutionArrayList) {
        this.context = context;
        this.institutionArrayList = institutionArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_institution, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context)
                .load(institutionArrayList.get(position).getImage())
                .into(holder.ivImage);
        holder.tvTitle.setText(institutionArrayList.get(position).getName());
        holder.tvDescription.setText(institutionArrayList.get(position).getWeblink());
        holder.llInstitution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=institutionArrayList.get(position).getWeblink();
                Intent intent=new Intent(context, WebActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("TAG",url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return institutionArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvDescription;
        private LinearLayout llInstitution;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            llInstitution=itemView.findViewById(R.id.llInstitution);
        }
    }
}

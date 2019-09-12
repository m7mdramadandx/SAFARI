package com.ramadan.safari.adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ramadan.safari.R;
import com.ramadan.safari.activities.selected_alex_landmark;
import com.ramadan.safari.model.Landmark_Blog;

import java.util.ArrayList;

public class alex_landmark_rcv_adp extends RecyclerView.Adapter<alex_landmark_rcv_adp.LandmarkViewHolder> {
    RequestOptions options;
    private Context mContext;
    private ArrayList<Landmark_Blog> landmark;


    public alex_landmark_rcv_adp(Context mContext, ArrayList landmark) {
        this.mContext = mContext;
        this.landmark = landmark;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public LandmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.landmark_blog_raw, parent, false);
        return new LandmarkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LandmarkViewHolder holder, int position) {
        Landmark_Blog Landmark_blog = landmark.get(position);

        String imageUrl = Landmark_blog.getLandmark_img_url();
        String location = Landmark_blog.getLandmark_location();
        String rate = Landmark_blog.getLandmark_rate();
        String landmark_name = Landmark_blog.getLandmark_name();

        holder.landmark_name.setText(landmark_name);
        holder.landmark_rate.setText(rate);
        holder.landmark_location.setText(location);
        Glide.with(mContext).asBitmap().load(imageUrl).into(holder.landmark_img);
    }

    @Override
    public int getItemCount() {
        return landmark.size();
    }


    public class LandmarkViewHolder extends RecyclerView.ViewHolder {
        TextView landmark_name, landmark_rate, landmark_location, landmark_cost;
        ImageView landmark_img;


        public LandmarkViewHolder(View itemView) {
            super(itemView);
            landmark_name = itemView.findViewById(R.id.landmark_name);
            landmark_rate = itemView.findViewById(R.id.landmark_rate);
            landmark_location = itemView.findViewById(R.id.landmark_location);
            landmark_cost = itemView.findViewById(R.id.one_ticket);
            landmark_img = itemView.findViewById(R.id.landmark_img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, selected_alex_landmark.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("landmark_name", landmark_name.getText().toString());
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);


                }
            });
        }
    }
}




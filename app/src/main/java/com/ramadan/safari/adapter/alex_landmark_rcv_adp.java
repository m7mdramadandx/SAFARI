package com.ramadan.safari.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ramadan.safari.R;
import com.ramadan.safari.model.Landmark_Blog;

import java.util.ArrayList;

public class alex_landmark_rcv_adp extends RecyclerView.Adapter<alex_landmark_rcv_adp.LandmarkViewHolder> {
    RequestOptions options;
    private Context mContext;
    private ArrayList<Landmark_Blog> landmark;
    private AdapterView.OnItemClickListener mListener;


    public alex_landmark_rcv_adp(Context mContext, ArrayList landmark) {
        this.mContext = mContext;
        this.landmark = landmark;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = (AdapterView.OnItemClickListener) listener;
    }

    @NonNull
    @Override
    public LandmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.alex_landmark_blog_raw, parent, false);
        return new LandmarkViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LandmarkViewHolder holder, int position) {
        Landmark_Blog Landmark_blog = landmark.get(position);

        String imageUrl = Landmark_blog.getLandmark_img_url();
        String location = Landmark_blog.getLandmark_location();
        String rate = Landmark_blog.getLandmark_rate();
        String landmark_name = Landmark_blog.getLandmark_name();
        String cost = Landmark_blog.getLandmark_cost();

        holder.landmark_name.setText(landmark_name);
        holder.rate.setText(rate);
        holder.location.setText(location);
        //holder.cost.setText(cost);
//        Picasso.with(mContext).load(imageUrl);
        Glide.with(mContext).asBitmap().load(imageUrl).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return landmark.size();
    }

    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    public class LandmarkViewHolder extends RecyclerView.ViewHolder {
        TextView landmark_name, rate, location;
        ImageView img;


        public LandmarkViewHolder(View itemView) {
            super(itemView);
            landmark_name = itemView.findViewById(R.id.landmark_name);
            rate = itemView.findViewById(R.id.landmark_rate);
            location = itemView.findViewById(R.id.landmark_location);
//          cost = itemView.findViewById(R.id.cost);
            img = itemView.findViewById(R.id.landmark_img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "dede", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}




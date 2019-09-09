package com.ramadan.safari.adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ramadan.safari.R;
import com.ramadan.safari.activities.selected_alex_hotel;
import com.ramadan.safari.model.Hotel_Blog;

import java.util.ArrayList;

public class alex_hotel_rcv_adp extends RecyclerView.Adapter<alex_hotel_rcv_adp.HotelViewHolder> {
    RequestOptions option;
    private Context mContext;
    private ArrayList<Hotel_Blog> hotel;
    private Hotel_Blog mhotel;
    private AdapterView.OnItemClickListener mListener;


    public alex_hotel_rcv_adp(Context mContext, ArrayList hotel) {
        this.mContext = mContext;
        this.hotel = hotel;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = (AdapterView.OnItemClickListener) listener;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hotel_blog_raw, parent, false);
        return new HotelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        Hotel_Blog Hotel_blog = hotel.get(position);

        String imageUrl = Hotel_blog.getHotel_img_url();
        String beach = Hotel_blog.getHotel_beach();
        String location = Hotel_blog.getHotel_location();
        String rate = Hotel_blog.getHotel_rate();
        String hotel_name = Hotel_blog.getHotel_name();
        //   String cost = Hotel_Blog.getCost();

        holder.hotel_name.setText(hotel_name);
        holder.rate.setText(rate);
        holder.location.setText(location);
        holder.beach.setText(beach);
        //holder.cost.setText(cost);
//        Picasso.with(mContext).load(imageUrl);
        Glide.with(mContext).asBitmap().load(imageUrl).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return hotel.size();
    }

    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder {
        TextView hotel_name, beach, rate, location, cost;
        ImageView img;


        public HotelViewHolder(View itemView) {
            super(itemView);
            hotel_name = itemView.findViewById(R.id.hotel_name);
            beach = itemView.findViewById(R.id.hotel_beach);
            rate = itemView.findViewById(R.id.hotel_rate);
            location = itemView.findViewById(R.id.hotel_location);
//          cost = itemView.findViewById(R.id.cost);
            img = itemView.findViewById(R.id.hotel_img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, selected_alex_hotel.class);
                    Bundle bundle = new Bundle();
                    //bundle.putSerializable("Data", mhotel);
                    bundle.putString("hotel_name", hotel_name.getText().toString());
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);

                }
            });
        }
    }
}




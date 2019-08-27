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
import com.ramadan.safari.model.Hotel_blog;

import java.util.ArrayList;

public class RvAdapter2 extends RecyclerView.Adapter<RvAdapter2.HotelViewHolder> {
    RequestOptions options;
    private Context mContext;
    private ArrayList<Hotel_blog> hotel;
    private AdapterView.OnItemClickListener mListener;


    public RvAdapter2(Context mContext, ArrayList hotel) {
        this.mContext = mContext;
        this.hotel = hotel;
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
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.blog_raw, parent, false);
        return new HotelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        Hotel_blog Hotel_blog = hotel.get(position);

        String imageUrl = Hotel_blog.getHotel_img_url();
        String beach = Hotel_blog.getHotel_beach();
        String location = Hotel_blog.getHotel_location();
        String rate = Hotel_blog.getHotel_rate();
        String hotel_name = Hotel_blog.getHotel_name();
        //   String cost = Hotel_blog.getCost();

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
                    Toast.makeText(mContext, "coming soon!", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}




package com.ramadan.safari.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ramadan.safari.R;
import com.ramadan.safari.model.offer;

import java.util.List;


public class RvAdapter2 extends RecyclerView.Adapter<RvAdapter2.ExampleViewHolder> {
    RequestOptions options;
    private Context mContext;
    private List<offer> mExampleList;
    private OnItemClickListener mListener;


    public RvAdapter2(Context mContext, List offer_list) {
        this.mContext = mContext;
        this.mExampleList = offer_list;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.offer_item_row, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        offer offer = mExampleList.get(position);


        String imageUrl = offer.getImg_url();
        String date = offer.getDate();
        String transportation_type = offer.getTransportation_type();
        String rate = offer.getRate();
        String hotel_name = offer.getHotel_name();
        String duration = offer.getDuration();
        String cost = offer.getCost();

        holder.hotel_name.setText(hotel_name);
        holder.date.setText(date);
        holder.rate.setText(rate);
        holder.duration.setText(duration);
        holder.transportation_type.setText(transportation_type);
        holder.cost.setText(cost);

        Glide.with(mContext).load(imageUrl).apply(options).into(holder.offer_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView hotel_name, date, rate, duration, transportation_type, cost;
        ImageView offer_thumbnail;


        public ExampleViewHolder(View itemView) {
            super(itemView);
            hotel_name = itemView.findViewById(R.id.hotel_name);
            date = itemView.findViewById(R.id.date);
            rate = itemView.findViewById(R.id.rate);
            duration = itemView.findViewById(R.id.duration);
            transportation_type = itemView.findViewById(R.id.transportation_type);
            cost = itemView.findViewById(R.id.cost);
            offer_thumbnail = itemView.findViewById(R.id.thumbnail);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}




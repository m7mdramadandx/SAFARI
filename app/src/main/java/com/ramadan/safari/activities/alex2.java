package com.ramadan.safari.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.ramadan.safari.R;
import com.ramadan.safari.adapter.RvAdapter2;
import com.ramadan.safari.model.offer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class alex2 extends AppCompatActivity {
    private String URL_JSON = "https://api.myjson.com/bins/17ar2v";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;
    private List<offer> lstOffer = new ArrayList<>();
    private RecyclerView myrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alex);
        myrv = findViewById(R.id.rv);
        jsoncall();
    }

    public void jsoncall() {
        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    //  Toast.makeText(getApplicationContext(), String.valueOf(i), Toast.LENGTH_SHORT).show();
                    try {
                        jsonObject = response.getJSONObject(i);
                        offer offer = new offer();
                        offer.setHotel_name(jsonObject.getString("hotel_name"));
                        offer.setDate(jsonObject.getString("date"));
                        offer.setRate(jsonObject.getString("rate"));
                        offer.setDuration(jsonObject.getString("duration"));
                        offer.setTransportation_type(jsonObject.getString("transportation_type"));
                        offer.setCost(jsonObject.getString("cost"));
                        offer.setImg_url(jsonObject.getString("img"));
                        lstOffer.add(offer);
                    } catch (JSONException e) {
                        System.out.println(e + "  ****");
                    }
                }
                // Toast.makeText(alex2.this, "Size of Liste " + String.valueOf(lstOffer.size()), Toast.LENGTH_SHORT).show();
                // Toast.makeText(alex2.this, lstOffer.get(1).toString(), Toast.LENGTH_SHORT).show();

                setRvadapter(lstOffer);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                System.out.println(e + "  //////");
            }
        });
        requestQueue = Volley.newRequestQueue(alex2.this);
        requestQueue.add(ArrayRequest);
    }

    public void setRvadapter(List<offer> lstOffer) {
        RvAdapter2 myAdapter = new RvAdapter2(this, lstOffer);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }
}


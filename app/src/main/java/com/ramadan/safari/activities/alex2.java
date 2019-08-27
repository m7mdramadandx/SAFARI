package com.ramadan.safari.activities;/*package com.ramadan.safari.activities;

import android.content.Intent;
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
import com.ramadan.safari.model.Hotel_blog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
*/

public class alex2 {
    /*extends AppCompatActivity
    private String URL_JSON = "https://api.myjson.com/bins/ab4oj";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;
    private List<Hotel_blog> lstHotelBlog = new ArrayList<>();
    private RecyclerView myrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alex);
        myrv = findViewById(R.id.recyclerview);
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
                        Hotel_blog Hotel_blog = new Hotel_blog();
                        Hotel_blog.setHotel_name(jsonObject.getString("hotel_name"));
                        Hotel_blog.setRate(jsonObject.getString("rate"));
                        Hotel_blog.setLocation(jsonObject.getString("location"));
                        Hotel_blog.setBeachfront(jsonObject.getString("beachfront"));
                        Hotel_blog.setImg_url(jsonObject.getString("img"));
                        lstHotelBlog.add(Hotel_blog);
                    } catch (JSONException e) {
                        System.out.println(e + "  ****");
                    }
                }
                // Toast.makeText(alex2.this, "Size of Liste " + String.valueOf(lstHotelBlog.size()), Toast.LENGTH_SHORT).show();
                // Toast.makeText(alex2.this, lstHotelBlog.get(1).toString(), Toast.LENGTH_SHORT).show();

                setRvadapter(lstHotelBlog);
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

    public void setRvadapter(List<Hotel_blog> lstHotelBlog) {
        RvAdapter2 myAdapter = new RvAdapter2(this, lstHotelBlog);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }

    //////////////////////------NAV BAR------//////////////////
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, com.ramadan.safari.activities.offer.class));
    }*/
}


/*
 JSONArray arr = new JSONArray(str);
for(int i = 0; i < arr.length(); i++){

    JSONObject jsonObj = (JSONObject)arr.get(i); // get the josn object
    if(jsonObj.getString("name").equals("Rose")){ // compare for the key-value
        ((JSONObject)arr.get(i)).put("id", 22); // put the new value for the key
    }
    textview.setText(arr.toString());// display and verify your Json with updated value
}
///////////////////////////////////////
private JSONObject setJSONVal(JSONObject jsonObject, String index, String value) throws JSONException{
   String jsonString = jsonObject.toString().trim();
   jsonString = jsonString.replace("\"" + index + "\":\"" + jsonObject.getString(index) + "\"", "\"" + index + "\":\"" + value + "\"");
   return new JSONObject(jsonString);
}
 */


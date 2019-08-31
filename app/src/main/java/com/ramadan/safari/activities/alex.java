package com.ramadan.safari.activities;

public class alex {/*
    extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.alex_hotel);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Hotel_2");
        mDatabase.keepSynced(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Hotel_Blog, view_holder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Hotel_Blog, view_holder>
                (Hotel_Blog.class, R.layout.hotel_blog_raw, view_holder.class, mDatabase) {
            @Override
            protected void populateViewHolder(view_holder view_holder, Hotel_Blog hotel_blog, int i) {
                view_holder.setHotel_beachfront(hotel_blog.getHotel_beach());
                view_holder.setHotel_img(getApplicationContext(), hotel_blog.getHotel_img_url());
                view_holder.setHotel_location(hotel_blog.getHotel_location());
                view_holder.setHotel_name(hotel_blog.getHotel_name());
                view_holder.setHotel_rate(hotel_blog.getHotel_rate());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public  class view_holder extends RecyclerView.ViewHolder{
        View view;

        public view_holder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
        }

        public void setHotel_name(String hotel_name) {
            TextView post_hotel_name =(TextView)view.findViewById(R.id.hotel_name);
            post_hotel_name.setText(hotel_name);
        }
        public void setHotel_rate(String hotel_rate) {
            TextView post_hotel_rate =(TextView)view.findViewById(R.id.hotel_rate);
            post_hotel_rate.setText(hotel_rate);
        }
        public void setHotel_location(String hotel_location) {
            TextView post_hotel_location =(TextView)view.findViewById(R.id.hotel_location);
            post_hotel_location.setText(hotel_location);
        }
        public void setHotel_beachfront(String hotel_beachfront) {
            TextView post_hotel_beachfront =(TextView)view.findViewById(R.id.hotel_beach);
            post_hotel_beachfront.setText(hotel_beachfront);
        }
        public void setHotel_img(Context context, String img){
            ImageView post_hotel_img = (ImageView)view.findViewById(R.id.hotel_img);
            Picasso.with(context).load(img);
        }
    }

*/
}

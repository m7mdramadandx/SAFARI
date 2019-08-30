package com.ramadan.safari.activities;

//import com.google.api.Context;

public class youmna2 {/*
    private FirebaseDatabase mDatabase ;

    public static ArrayList<Hotel_Blog> getCities(final Cafes cafes, final Context context) {
        final ArrayList<Hotel_Blog> mhotel_blog = new ArrayList<>();

        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Hotel");
//        cafes.progressbar.setVisibility(View.VISIBLE);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                try {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        final Hotel_Blog alarm = postSnapshot.getValue(Hotel_Blog.class);

                        mhotel_blog.add(alarm);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Cities_Adapter mAdapter = new Cities_Adapter(context, mhotel_blog);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                cafes.recyclerView_cityies.setLayoutManager(mLayoutManager);
                cafes.recyclerView_cityies.setItemAnimator(new DefaultItemAnimator());
                cafes.recyclerView_cityies.setAdapter(mAdapter);
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(cafes.recyclerView_cityies.getContext(),
                        DividerItemDecoration.VERTICAL);
                cafes.recyclerView_cityies.addItemDecoration(dividerItemDecoration);
                cafes.progressbar.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("kkk", "Failed to read value.", error.toException());
            }
        });

        return mhotel_blog;
    }*/
}
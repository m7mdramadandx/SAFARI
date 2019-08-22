package com.ramadan.safari.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ramadan.safari.R;

public class test extends AppCompatActivity {
    EditText textView;
    DatabaseReference myRef;
    String value = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_test);
        textView = findViewById(R.id.sese);
        myRef = FirebaseDatabase.getInstance().getReference("Name");

        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value = dataSnapshot.getValue(String.class);
                System.out.println("Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read value." + error.toException());
            }
        });*/
    }

    public void add(View view) {
        String s = textView.getText().toString();
        myRef.child("Name").setValue(s);

        textView.setText(value);

    }
}

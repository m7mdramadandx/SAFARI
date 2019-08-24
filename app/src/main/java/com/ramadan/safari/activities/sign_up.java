package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ramadan.safari.R;

public class sign_up extends AppCompatActivity {
    ProgressBar progressBar;
    EditText first_name, last_name, age, location, email, phone, password, password2;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        age = findViewById(R.id.age);
        location = findViewById(R.id.location);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, main.class));
    }

    public void submit(View view) {
        final String first_name_ = first_name.getText().toString();
        final String last_name_ = last_name.getText().toString();
        String age_ = age.getText().toString();
        final String email_ = email.getText().toString();
        final String location_ = location.getText().toString();
        String phone_ = phone.getText().toString();
        String password_ = password.getText().toString();
        String password2_ = password2.getText().toString();
        progressBar.setVisibility(View.VISIBLE);

        if (first_name_.isEmpty() || last_name_.isEmpty() || location_.isEmpty() || age_.isEmpty() || email_.isEmpty() || phone_.isEmpty() || password_.isEmpty() || password2_.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            if (password_.equals(password2_)) {
                final int age__ = Integer.parseInt(age_);
                final int phone__ = Integer.parseInt(phone_);
                mAuth.createUserWithEmailAndPassword(email_, password_).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String user_id = mAuth.getCurrentUser().getUid();
                            FirebaseUser user = mAuth.getCurrentUser();
                            DatabaseReference current_user_db = mDatabase.child(user_id);
                            current_user_db.child("user_id").setValue(user_id);
                            current_user_db.child("first_name").setValue(first_name_);
                            current_user_db.child("last_name").setValue(last_name_);
                            current_user_db.child("email").setValue(email_);
                            current_user_db.child("phone").setValue(phone__);
                            current_user_db.child("age").setValue(age__);
                            current_user_db.child("location").setValue(location_);
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(sign_up.this, home.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivities(new Intent[]{intent});
                            finish();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(sign_up.this, "sign up failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //user_ = new user(first_name_, last_name_, email_, phone__, age__, password_);
                //Map<String, Object> user_values = user_.toMap();
                //Map<String, Object> child_updates = new HashMap<>();
                //child_updates.put(user_id, user_values);
                //FirebaseDatabase.getInstance().getReference("user").updateChildren(child_updates);

            } else {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(this, "passwords are not matched", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

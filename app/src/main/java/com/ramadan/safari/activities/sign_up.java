package com.ramadan.safari.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ramadan.safari.R;

import es.dmoral.toasty.Toasty;

public class sign_up extends AppCompatActivity {
    ProgressBar progressBar;
    TextInputLayout email_layout, phone_layout;
    EditText first_name, last_name, city, email, phone, password, password2;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mDatabase = FirebaseDatabase.getInstance().getReference("user");
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        city = findViewById(R.id.city);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
    }


    public void submit(View view) {
        final String first_name_ = first_name.getText().toString();
        final String last_name_ = last_name.getText().toString();
        final String email_ = email.getText().toString();
        final String city_ = city.getText().toString();
        final String phone_ = phone.getText().toString();
        final String password_ = password.getText().toString();
        String password2_ = password2.getText().toString();
        progressBar.setVisibility(View.VISIBLE);

        if (first_name_.isEmpty() || last_name_.isEmpty() || city_.isEmpty() || email_.isEmpty() || phone_.isEmpty() || password_.isEmpty() || password2_.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            Toasty.error(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            if (password_.equals(password2_)) {
                mAuth.createUserWithEmailAndPassword(email_, password_).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Toasty.error(sign_up.this, "sign up failed", Toast.LENGTH_SHORT).show();
                        } else {
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = mDatabase.child(user_id);
                            current_user_db.child("user_id").setValue(user_id);
                            current_user_db.child("first_name").setValue(first_name_);
                            current_user_db.child("last_name").setValue(last_name_);
                            current_user_db.child("email").setValue(email_);
                            current_user_db.child("phone").setValue(phone_);
                            current_user_db.child("city").setValue(city_);
                            current_user_db.child("password").setValue(password_);
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(sign_up.this, welcome.class));
                            Animatoo.animateZoom(sign_up.this);
                            Toasty.success(sign_up.this, "Registration completed successfully", Toast.LENGTH_SHORT, true).show();
                            finish();
                        }
                    }
                });

            } else {
                progressBar.setVisibility(View.GONE);
                Toasty.error(this, "passwords are not matched", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

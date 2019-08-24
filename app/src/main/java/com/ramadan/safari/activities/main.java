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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.ramadan.safari.R;

public class main extends AppCompatActivity {
    //database_handler db;
    EditText password, email;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //  db = new database_handler(this);
        email = findViewById(R.id.email_field);
        password = findViewById(R.id.password_field);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void sign_up(View view) {
        startActivity(new Intent(this, sign_up.class));
        finish();
    }

    public void login(View view) {
        String email_ = email.getText().toString();
        String password_ = password.getText().toString();
        progressBar.setVisibility(View.VISIBLE);
        if (email_.isEmpty() || password_.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.fetchSignInMethodsForEmail(email_).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                @Override
                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                    boolean exist = task.getResult().getSignInMethods().isEmpty();
                    if (exist) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(main.this, "you need to create an account at first!", Toast.LENGTH_LONG).show();
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Intent intent = new Intent(main.this, home.class);
                        intent.putExtra("status", "old_user");
                        startActivity(intent);
                        Toast.makeText(main.this, "welcome!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
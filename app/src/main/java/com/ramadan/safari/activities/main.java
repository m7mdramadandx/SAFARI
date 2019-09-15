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
import com.ramadan.safari.R;

import es.dmoral.toasty.Toasty;

public class main extends AppCompatActivity {
    EditText password, email;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        if (mUser != null) {
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
            finish();
            Toasty.normal(this, "welcome back buddy", getResources().getDrawable(R.drawable.ic_smile)).show();
        }
        setContentView(R.layout.main);
        email = findViewById(R.id.email_field);
        password = findViewById(R.id.password_field);
        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();


    }


    public void sign_up(View view) {
        startActivity(new Intent(this, sign_up.class));
    }

    public void login(View view) {
        String email_ = email.getText().toString();
        String password_ = password.getText().toString();
        progressBar.setVisibility(View.VISIBLE);
        if (email_.isEmpty() || password_.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            Toasty.error(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(email_, password_).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.GONE);
                    if (!task.isSuccessful()) {
                        Toasty.error(main.this, "wrong email or password", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(main.this, home.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

        }
    }
}
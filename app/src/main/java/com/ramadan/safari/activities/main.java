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
import com.ramadan.safari.R;

public class main extends AppCompatActivity {
    //database_handler db;
    EditText password, email;
    ProgressBar progressBar;
    FirebaseAuth auth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //  db = new database_handler(this);
        email = findViewById(R.id.email_field);
        password = findViewById(R.id.password_field);
        progressBar = findViewById(R.id.progressBar);
        auth = FirebaseAuth.getInstance();
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
            Toast.makeText(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            auth.createUserWithEmailAndPassword(email_, password_).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressBar.setVisibility(View.GONE);
                        System.out.println("signInWithEmail:success");
                        Toast.makeText(main.this, "welcome!", Toast.LENGTH_SHORT).show();
                        //FirebaseUser user = auth.getCurrentUser();
                        //updateUI(user);
                    } else {
                        progressBar.setVisibility(View.GONE);
                        System.out.println("signInWithEmail:failure" + task.getException());
                        Toast.makeText(main.this, "email or password is not correct", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                        //updateUI(null);
                    }
                }
            });
        }
    }
}

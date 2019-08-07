package com.example.safari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class main extends Activity {
    database_handler db;
    EditText password, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db = new database_handler(this);
        phone = findViewById(R.id.phone_field);
        password = findViewById(R.id.password_field);

    }

    public void sign_up(View view) {
        Intent intent = new Intent(this, sign_up.class);
        startActivity(intent);
        finish();
    }

    public void login(View view) {
        String phone_ = phone.getText().toString();
        String password_ = password.getText().toString();
        if (phone_.isEmpty() || password_.isEmpty()) {
            Toast.makeText(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            int phone__ = Integer.parseInt(phone_);
            boolean status = db.search_user(phone__, password_);
            if (status == true) {
                if (phone__ == 11) {
                    Intent intent = new Intent(this, staff_home.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(this, "welcome offers_controller!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, home_page.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(this, "welcome!", Toast.LENGTH_SHORT).show();
                }
            } else if (status == false) {
                Toast.makeText(this, "incorrect phone or password!", Toast.LENGTH_SHORT).show();

            }

        }
    }
}

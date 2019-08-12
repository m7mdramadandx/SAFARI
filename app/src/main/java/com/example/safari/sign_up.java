package com.example.safari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends Activity {
    database_handler db;
    EditText full_name, age, phone, password, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        db = new database_handler(this);
        full_name = findViewById(R.id.full_name);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);

    }

    public void submit(View view) {
        String full_name_ = full_name.getText().toString();
        String age_ = age.getText().toString();
        String phone_ = phone.getText().toString();
        String password_ = password.getText().toString();
        String password2_ = password2.getText().toString();

        if (full_name_.isEmpty() || age_.isEmpty() || phone_.isEmpty() || password_.isEmpty() || password2_.isEmpty()) {
            Toast.makeText(this, "all fields are required!", Toast.LENGTH_SHORT).show();
        } else {
            if (password_.equals(password2_)) {
                int age__ = Integer.parseInt(age_);
                int phone__ = Integer.parseInt(phone_);
                db.insert_user(phone__, full_name_, age__, password_);
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, home.class);
                startActivities(new Intent[]{intent});
                finish();

            } else {
                Toast.makeText(this, "passwords are not matched", Toast.LENGTH_SHORT).show();
            }
        }


    }
}

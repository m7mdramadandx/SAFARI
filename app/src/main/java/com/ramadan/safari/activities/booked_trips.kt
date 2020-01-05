package com.ramadan.safari.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramadan.safari.R
import kotlinx.android.synthetic.main.bottom_bar.*

@SuppressLint("Registered")
class MainActivity : AppCompatActivity(R.layout.booked_trips) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomBar.onItemSelected = {
            startActivity(Intent(this, dashboard::class.java))
        }

        bottomBar.onItemReselected = {
            startActivity(Intent(this,favorite::class.java))
        }
    }
}
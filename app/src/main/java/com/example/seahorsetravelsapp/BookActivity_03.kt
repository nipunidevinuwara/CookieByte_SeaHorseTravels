package com.example.seahorsetravelsapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BookActivity_03 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book03)

        var Btn = findViewById<Button>(R.id.pay)
        Btn.setOnClickListener {
            val intent = Intent(this, Booking_Success::class.java)
            startActivity(intent)

        }
    }
}
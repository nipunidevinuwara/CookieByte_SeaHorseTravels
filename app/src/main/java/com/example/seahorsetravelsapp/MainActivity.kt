package com.example.seahorsetravelsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.seahorsetravelsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        binding.customToolBar.number1.setOnClickListener {
            Toast.makeText(this, "Number 1 Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.customToolBar.number2.setOnClickListener {
            Toast.makeText(this, "Number 12Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.customToolBar.number3.setOnClickListener {
            Toast.makeText(this, "Number 3 Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
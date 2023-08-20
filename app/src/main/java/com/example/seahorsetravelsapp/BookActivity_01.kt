package com.example.seahorsetravelsapp

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BookActivity_01 : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    private lateinit var spinner: Spinner
    private lateinit var book_arrow: ImageView
    private lateinit var destination: RadioGroup

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book01)

        spinner = findViewById(R.id.spinner)
        book_arrow = findViewById(R.id.book_Arrow1)
        destination = findViewById(R.id.destinate)
        val items = arrayOf("Earth", "Mars", "Mercury", "Venus", "Saturn", "Jupiter", "Neptune")
        val result = findViewById<TextView>(R.id.test1)
        databaseReference = FirebaseDatabase.getInstance().reference
        val option1 = findViewById<RadioButton>(R.id.Mars)
        val option2 = findViewById<RadioButton>(R.id.Mercury)
        val option3 = findViewById<RadioButton>(R.id.Earth)
        val option4 = findViewById<RadioButton>(R.id.Venus)
        val option5 = findViewById<RadioButton>(R.id.Saturn)
        val option6 = findViewById<RadioButton>(R.id.Jupiter)
        val option7 = findViewById<RadioButton>(R.id.Neptune)
        val selectedSpinnerItem = spinner.selectedItem.toString()
        val checkedRadioButtonId = destination.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)
        val selectedRadioButtonText = selectedRadioButton.text.toString()

        val dataMap = mapOf(
            "spinnerChoice" to selectedSpinnerItem,
            "radioButtonChoice" to selectedRadioButtonText)

        val newKey = databaseReference.child("data").push().key

        if (newKey != null) {
            databaseReference.child("data").child(newKey).setValue(dataMap)
        }

//        destination.setOnCheckedChangeListener { _, checkedId ->
//            val selectedRadioButton = findViewById<RadioButton>(checkedId)
//            selectedPlanet = selectedRadioButton.text.toString()
//        }
//
//
//
//        book_arrow.setOnClickListener {
//            val intent = Intent(this, BookActivity_02::class.java)
//            intent.putExtra("selectedGender", selectedPlanet)
//            intent.putExtra("From",items)
//            startActivity(intent)
//        }


    }
}









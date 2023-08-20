package com.example.seahorsetravelsapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import java.lang.String
import java.util.*

class BookActivity_02 : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var progressDialog: ProgressDialog

    var timeButton: Button? = null
    var hour = 0
    var minute: Int = 0
    private var datePickerDialog: DatePickerDialog? = null
    private lateinit var dateButton: Button
    private lateinit var book_Arrow2: ImageView
    lateinit var hyperDrive: Button
    lateinit var spaceJump: Button
    lateinit var solarSoil: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book02)

        timeButton = findViewById(R.id.timeButton);
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.text = getTodaysDate();
        hyperDrive = findViewById(R.id.Neptune)
        spaceJump = findViewById(R.id.spaceJump)
        solarSoil = findViewById(R.id.solarSail)
        book_Arrow2 = findViewById(R.id.book_Arrow2)



        initDatePicker();

//       var selectedOption = intent.getStringExtra("destination") ?: ""
//       var selectedOption1 = intent.getStringExtra("From") ?: ""
//
//        print(selectedOption)
//        print(selectedOption1.toString())


        book_Arrow2.setOnClickListener {
            var intent = Intent(this, BookActivity_03::class.java)
            startActivity(intent)
        }


    }


    private fun getTodaysDate(): kotlin.String? {
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        var month = cal[Calendar.MONTH]
        month = month + 1
        val day = cal[Calendar.DAY_OF_MONTH]
        return makeDateString(day, month, year)
    }

    private fun initDatePicker() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            var month = month
            month = month + 1
            val date = makeDateString(day, month, year)
            dateButton!!.text = date
        }
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]
        val style: Int = AlertDialog.THEME_HOLO_LIGHT
        datePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    private fun makeDateString(day: Int, month: Int, year: Int): kotlin.String? {
        return getMonthFormat(month) + " " + day + " " + year
    }

    private fun getMonthFormat(month: Int): kotlin.String {
        if (month == 1) return "JAN"
        if (month == 2) return "FEB"
        if (month == 3) return "MAR"
        if (month == 4) return "APR"
        if (month == 5) return "MAY"
        if (month == 6) return "JUN"
        if (month == 7) return "JUL"
        if (month == 8) return "AUG"
        if (month == 9) return "SEP"
        if (month == 10) return "OCT"
        if (month == 11) return "NOV"
        return if (month == 12) "DEC" else "JAN"

        //default should never happen
    }

    fun openDatePicker(view: View?) {
        datePickerDialog!!.show()
    }

    fun popTimePicker(view: View?) {
        val onTimeSetListener =
            TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                hour = selectedHour
                minute = selectedMinute
                timeButton?.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute))
            }

        // int style = AlertDialog.THEME_HOLO_DARK;
        val timePickerDialog =
            TimePickerDialog(this,  /*style,*/onTimeSetListener, hour, minute, true)
        timePickerDialog.setTitle("Select Time")
        timePickerDialog.show()

    }


}
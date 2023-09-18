package com.example.datepicker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var selectedDateTextView: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectedDateTextView = findViewById<TextView>(R.id.selectedDate)
        val showDatePickerButton = findViewById<Button>(R.id.showDatePicker)

        showDatePickerButton.setOnClickListener {
            showDatePicker()
        }
    }
    fun showDatePicker(){
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DATE)

        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, monthOfYear, dayOfMonth ->
            val  month1 = monthOfYear +1
            selectedDateTextView.text = "$dayOfMonth / 0$month1 /$year"

        } ,
            year, month, day)

        datePickerDialog.show()

    }
}
package com.example.m205_tp_datepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)


        // Set a click listener for the button
        btnDatePicker.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val anneeActuel = calendar.get(Calendar.YEAR)
        val moisActuel = calendar.get(Calendar.MONTH)
        val jourActuel = calendar.get(Calendar.DAY_OF_MONTH)

        val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Display the selected date in the TextView
                val selectedDate = "$year-${monthOfYear + 1}-$dayOfMonth"
                tvSelectedDate.text = selectedDate
            },
            anneeActuel,
            moisActuel,
            jourActuel
        )

        // Show the date picker dialog
        datePickerDialog.show()
    }
}
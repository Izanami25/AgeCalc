package com.example.ageinminutesapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me = findViewById(R.id.btnDatePicker) as Button

        btn_click_me.setOnClickListener { view ->
            clickDatePicker(view)
        }
    }
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
            view, selectedyear, selectedmonth, selecteddayOfMonth ->
            Toast.makeText(this, "The year is $selectedyear, the month is $selectedmonth and the day is $selecteddayOfMonth", Toast.LENGTH_LONG).show()
            //selected date
            val selectedDate = "$selecteddayOfMonth/${selectedmonth + 1}/$selectedyear"
            val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)
            tvSelectedDate.setText(selectedDate)
        }

        ,year,month,day).show()

        //selected date



    }
}
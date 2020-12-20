package com.example.lab1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class Lab4Activity : AppCompatActivity() {
    private lateinit var Employee : TextView
    private lateinit var employee : EditText
    private lateinit var Department : TextView
    private lateinit var spinner : Spinner
    private lateinit var Address : TextView
    private lateinit var address : EditText
    private lateinit var Date : TextView
    private lateinit var date : TextView
    private lateinit var Submit : Button
    private lateinit var TV : TextView
    private lateinit var datePickerDialog: DatePickerDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4)
        Employee = findViewById(R.id.employee)
        employee = findViewById(R.id.emp1)
        Department = findViewById(R.id.tvdep)
        spinner = findViewById(R.id.spinner)
        Address = findViewById(R.id.tvadd)
        address  = findViewById(R.id.add1)
        Date = findViewById(R.id.tvdate)
        date = findViewById(R.id.date)
        Submit = findViewById(R.id.submit)
        TV = findViewById(R.id.tv1)

        date.setOnClickListener {
            loadCalendar()
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        datePickerDialog = DatePickerDialog(
            this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth -> date.setText("${year}-${month+1}-${dayOfMonth}") },year,month,day
        )
        datePickerDialog.show()

    }
}
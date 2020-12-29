package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class Lab6 : AppCompatActivity() {
    private lateinit var Name : EditText
    private lateinit var Address : EditText
    private lateinit var Mobile : EditText
    private lateinit var Gender : RadioGroup
    private lateinit var Submit : Button
    var listofperson = arrayListOf<Person>()
    var gender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab6)

        binding()
        listener()
        Submit.setOnClickListener {
            var person = Person(Name.text.toString(),Address.text.toString(),Mobile.text.toString(),gender)
            listofperson.add(person)
            startActivity(Intent(this,ShowDetail::class.java)
                .putExtra("detail",listofperson))
        }

    }

    private fun listener() {
        Gender.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.Male->gender = "male"
                    R.id.Female ->gender = "female"
                }
            }
        })
    }

    private fun binding() {
        Name = findViewById(R.id.etName)
        Address = findViewById(R.id.etAddress)
        Mobile = findViewById(R.id.etMobile)
        Gender = findViewById(R.id.rgGender)
        Submit = findViewById(R.id.btnSubmit)
    }
}
package com.example.lab1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import android.widget.*
import androidx.appcompat.app.AlertDialog

class Lab5Activity : AppCompatActivity() {
    private val Section = arrayOf("25 'A'", "25 'B'", "25 'C'", "25 'D'")
    private val Department1 = arrayOf("Academic", "Strategic", "Management", "Counselling")
    private lateinit var Name : EditText
    private lateinit var Radio : RadioGroup
    private lateinit var Email : EditText
    private lateinit var student : TextView
    private lateinit var Spinner : Spinner
    private lateinit var Student : EditText
    private lateinit var Department : TextView
    private lateinit var Batch : TextView
    private lateinit var Password : EditText
    private lateinit var Cpassword : EditText
    private lateinit var Register : Button
    lateinit var a :Array<String>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5)
        Radio = findViewById(R.id.Radio)
        Name = findViewById(R.id.Name)
        Email = findViewById(R.id.Email)
        Spinner = findViewById(R.id.depSpinner)
        Student = findViewById(R.id.studentID)
        student = findViewById(R.id.student)
        Department = findViewById(R.id.Department)
        Batch = findViewById(R.id.Batch)
        Password = findViewById(R.id.Password)
        Cpassword = findViewById(R.id.Cpassword)
        Register = findViewById(R.id.Register)


        Radio.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId) {
                    R.id.rbStudent->{
                        Spinner.adapter = ArrayAdapter(this@Lab5Activity, android.R.layout.simple_list_item_1, Section)
                        Department.visibility = View.GONE
                        Batch.visibility = View.VISIBLE

                    }
                    R.id.rbStaff ->{
                        Spinner.adapter = ArrayAdapter(this@Lab5Activity, android.R.layout.simple_list_item_1, Department1
                        )
                        Batch.visibility = View.GONE
                        student.visibility = View.GONE
                        Student.visibility = View.GONE
                        Department.visibility=View.VISIBLE
                    }
                }
            }
        })
        Radio.check(R.id.rbStudent)
        Register.setOnClickListener {
            alert()
        }
    }

    private fun alert()
    {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Alert!!")
//        alertDialog.setMessage("Are you sure you want to proceed.")
        alertDialog.setNeutralButton("Cancel")
        { dialogInterface: DialogInterface, i: Int ->

        }
        a = arrayOf(Name.text.toString(),Email.text.toString(),Spinner.selectedItem.toString(),Student.text.toString())
        alertDialog.setCancelable(false)
        alertDialog.setAdapter(ArrayAdapter(this,android.R.layout.simple_list_item_1,a),
        object :DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
//                TODO("Not yet implemented")
            }

        });

        alertDialog.create().show()

    }

}
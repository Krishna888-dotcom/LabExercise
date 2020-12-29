package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ShowDetail : AppCompatActivity() {
    private lateinit var listview : ListView
    private lateinit var Detail : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        listview = findViewById(R.id.lstPerson)
        Detail = findViewById(R.id.tvDetail)
        var list = intent.getSerializableExtra("detail") as ArrayList<Person>

         listview.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listview.setOnItemClickListener(object :AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Detail.setText(list.get(position).Name)
            }
        })

    }
}
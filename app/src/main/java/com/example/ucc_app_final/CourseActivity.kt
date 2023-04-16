package com.example.ucc_app_final

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseActivity : AppCompatActivity(){
    private lateinit var homeBtn: FloatingActionButton
    private lateinit var results1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        homeBtn = findViewById(R.id.homeBtn)
        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        // below code is to add on click
        // listener to our add name button

        // below code is to add on click
        // listener to our print name button

        // creating a DBHelper class
        // and passing context to it


        // below is the variable for cursor
        // we have called method to get
        // all names from our database
        // and add to name text view

        getData()
    }
    fun getData(){
        val db = DBHelper(this, null)
        val data = db.getName()
        results1 = findViewById(R.id.results1)
        results1.text = ""
        for (i in 0 until data.size){
            results1.append("\n Course Code: " + data[i].ccode + "\n Course: " + data[i].cname + "\n Credits: " + data[i].credits + "\n Pre-Requisites: " + data[i].prerec + "\n Description: "+ data[i].descreption + "\n\n")
        }
    }
}

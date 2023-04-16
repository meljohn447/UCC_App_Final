package com.example.ucc_app_final

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ucc_app_final.databinding.ActivityCoursesBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CoursesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCoursesBinding
    private lateinit var homeBtn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        homeBtn = findViewById(R.id.homeBtn)
        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // below code is to add on click
        // listener to our add name button
        binding.addbtn.setOnClickListener{

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelper(this, null)

            // creating variables for values
            // in name and age edit texts
            val ccode = binding.ccode.text.toString()
            val cname = binding.cname.text.toString()
            val credits = binding.credits.text.toString()
            val prereqs = binding.prereq.text.toString()
            val description = binding.description.text.toString()


            // calling method to add
            // name to our database
            db.addName(ccode, cname, credits, prereqs, description)

            // Toast to message on the screen
            Toast.makeText(this, ccode + " added Successfully", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            binding.ccode.text.clear()
            binding.cname.text.clear()
            binding.credits.text.clear()
            binding.prereq.text.clear()
            binding.description.text.clear()
        }

        // below code is to add on click
        // listener to our print name button

        // creating a DBHelper class
        // and passing context to it
        val db = DBHelper(this, null)

        binding.viewbtn.setOnClickListener{
            val data = db.getName()
            binding.results.text = ""
            for (i in 0 until data.size){
                binding.results.append("\n Course Code: " + data[i].ccode + "\n Course: " + data[i].cname + "\n Credits: " + data[i].credits + "\n Pre-Requisites: " + data[i].prerec + "\n Description: "+ data[i].descreption + "\n\n")
            }
        }
    }
}

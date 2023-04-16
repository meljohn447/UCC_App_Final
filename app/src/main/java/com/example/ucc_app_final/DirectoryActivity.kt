package com.example.ucc_app_final

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.floatingactionbutton.FloatingActionButton

class DirectoryActivity : AppCompatActivity(){
    private lateinit var homeBtn: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)

        homeBtn = findViewById(R.id.homeBtn)
        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val staffLists: Array<String> = resources.getStringArray(R.array.staffLists)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, staffLists)

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Clicked item : "+position, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, StaffDetailsActivity::class.java)
            intent.putExtra("listIndex", position.toString())
            this.startActivity(intent)
        }
}
}
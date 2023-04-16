package com.example.ucc_app_final

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ucc_app_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val url: String = "https://ucc.edu.jm/apply/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//  Admission button for redirecting to the external UCC website
        val  buttonWs: Button = findViewById(R.id.admissionbtn)
        buttonWs.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
            finish()
        }

//  Social media Button for passing the intent function to load the social media page with the app
        val web: Button = findViewById(R.id.socialbtn)
        web.setOnClickListener{
            val intent = Intent(this, SocialActivity::class.java)
            startActivity(intent)
            finish()
        }

//  Emailing button for composing the email and the copping all the fields to the respective emailing client.
        binding.emailbtn.setOnClickListener{
        val intent = Intent(this, EmailActivity::class.java)
        startActivity(intent)
        finish()
        }

//  Courses Button for passing the intent function to load the Courses page with the app
        val courses: Button = findViewById(R.id.coursebtn)
        courses.setOnClickListener{
            val intent = Intent(this, CoursesActivity::class.java)
            startActivity(intent)
            finish()
        }
//  Courses Button for passing the intent function to load the Courses page with the app
        val course: Button = findViewById(R.id.viewCoursesbtn)
        course.setOnClickListener{
            val intent = Intent(this, CourseActivity::class.java)
            startActivity(intent)
            finish()
        }
//  Courses Button for passing the intent function to load the Courses page with the app
        val directoryBtn: Button = findViewById(R.id.directorybtn)
        directoryBtn.setOnClickListener{
            val intent = Intent(this, DirectoryActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}
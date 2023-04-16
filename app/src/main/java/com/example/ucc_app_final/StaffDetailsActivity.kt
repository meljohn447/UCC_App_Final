package com.example.ucc_app_final

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StaffDetailsActivity : AppCompatActivity () {
    private lateinit var homeBtn: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staffdetails)

        homeBtn = findViewById(R.id.homeBtn)
        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        val staffList: String? = this.intent.getStringExtra("listIndex")
        val name: TextView = findViewById(R.id.staffName)
        val phoneNo: TextView = findViewById(R.id.staffPhoneNo)
        val email: TextView = findViewById(R.id.staffEmail)
        val staffPic: ImageView = findViewById(R.id.staffPic)

        when (staffList) {
            "0" -> {
                name.text = "Natalie Rose"
                email.text = "ithod@ucc.edu.jm"
                phoneNo.text = "876-420-6736"
                staffPic.setImageResource(R.drawable.rose)
            }
            "1" -> {
                name.text = "Sonia Davidson"
                email.text = "businessadminhod@ucc.edu.jm"
                phoneNo.text = "876-420-6736"
                staffPic.setImageResource(R.drawable.davidson)
            }
            "2" -> {
                name.text = "Tom Amonde"
                email.text = "graduatestudiesdirector@ucc.edu.jm"
                phoneNo.text = "876-420-6736"
                staffPic.setImageResource(R.drawable.amonde)
            }
            "3" -> {
                name.text = "Ionie Miller"
                email.text = "appliedpsychologyfaculty@ucc.edu.jm"
                phoneNo.text = "876-420-6736"
                staffPic.setImageResource(R.drawable.miller)
            }
            "4" -> {
                name.text = "Peter Ndajah"
                email.text = "headofschoolsmathit@ucc.edu.jm"
                phoneNo.text = "876-420-6736"
                staffPic.setImageResource(R.drawable.ndajah)
            }
        }
        email.setOnClickListener {
            val mail = email.text
            val addresses = mail.split(",".toRegex()).toTypedArray()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, addresses)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@StaffDetailsActivity,
                    "Required App is not Installed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
//        For prassing the number and loading the dialer
        phoneNo.setOnClickListener {
            val phNumber = phoneNo.text
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phNumber as String?, null))
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@StaffDetailsActivity,
                    "Required App is not Installed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
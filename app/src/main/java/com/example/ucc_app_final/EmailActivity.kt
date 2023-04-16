package com.example.ucc_app_final

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ucc_app_final.databinding.ActivityEmailBinding


class EmailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Emailing button for composing the email and the copping all the fields to the respective emailing client.
        binding.sendbtn.setOnClickListener{
            val subject = binding.subject.text.toString()
            val message = binding.message.text.toString()
            val mail: String = "ucconline@ucc.edu.jm"

            val addresses = mail.split(",".toRegex()).toTypedArray()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,addresses)
                putExtra(Intent.EXTRA_SUBJECT,subject)
                putExtra(Intent.EXTRA_TEXT,message)
            }
            if (intent.resolveActivity(packageManager)!= null) {
                startActivity(intent)
            }else{
                Toast.makeText(this@EmailActivity,"Required App is not Installed", Toast.LENGTH_SHORT).show()
            }

        }
        binding.homebtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
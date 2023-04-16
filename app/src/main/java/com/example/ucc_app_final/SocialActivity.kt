package com.example.ucc_app_final

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SocialActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var homeBtn: FloatingActionButton
    private lateinit var twitterbtn: FloatingActionButton
    private lateinit var facebookbtn: FloatingActionButton
    private lateinit var instagrambtn: FloatingActionButton

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social)

        webView = findViewById(R.id.webView)
        homeBtn = findViewById(R.id.homeBtn)
        instagrambtn = findViewById(R.id.instagrambtn)
        facebookbtn = findViewById(R.id.facebookbtn)
        twitterbtn = findViewById(R.id.twitterbtn)

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.youtube.com/user/uccjamaica")

        instagrambtn.setOnClickListener{
            webView.loadUrl("https://www.instagram.com/uccjamaica")
        }
        facebookbtn.setOnClickListener{
            webView.loadUrl("https://www.facebook.com/uccjamaica/photos/?ref=page_internal")
        }
        twitterbtn.setOnClickListener{
            webView.loadUrl("https://www.twitter.com/uccjamaica")
        }
        homeBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

    }

}
package com.example.newsinfo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.newsinfo.ui.NewsActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loadUi()
    }

    private fun loadUi() {
        Handler(Looper.getMainLooper()).postDelayed({
            val mIntent = Intent(this@SplashActivity, NewsActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 3000)
    }
}

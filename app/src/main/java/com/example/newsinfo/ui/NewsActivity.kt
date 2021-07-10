package com.example.newsinfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsinfo.R

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        actionBar?.hide()
        updateUi()
    }

    private fun updateUi() {
        supportFragmentManager.beginTransaction().add(R.id.container, WorldNewsFragment()).commit()
    }
}
package com.example.recycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Getstaeted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getstaeted)

        val tolog: Button =findViewById(R.id.mainToLogin)
        tolog.setOnClickListener {
            val intent= Intent(this, Logactivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
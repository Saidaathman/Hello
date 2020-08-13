package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvRegister.setOnClickListener {
            val intent= Intent(baseContext,Registration::class.java)
            startActivity(intent)
        }

        btnLogIn.setOnClickListener{
            var userName=etUserName.text.toString()
            var password=etPassword.text.toString()
            Toast.makeText(baseContext,password,LENGTH_SHORT).show()

        }

    }
}
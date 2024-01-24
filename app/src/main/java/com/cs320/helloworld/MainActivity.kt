package com.cs320.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<Button>(R.id.mainLogin)

        val registerBtn = findViewById<Button>(R.id.mainRegister)

        loginBtn.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

//        loginBtn.setOnClickListener {
//            val intent = Intent(this, Login::class.java)
//            startActivity(intent)
//        }

        registerBtn.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}
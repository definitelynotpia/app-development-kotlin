package com.cs320.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1)
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2)
        val radioButton3 = findViewById<RadioButton>(R.id.radioButton3)

        radioButton1.setOnClickListener {
            Toast.makeText(this, "You are male.", Toast.LENGTH_SHORT).show()
        }

        radioButton2.setOnClickListener {
            Toast.makeText(this, "You are female.", Toast.LENGTH_SHORT).show()
        }

        radioButton3.setOnClickListener {
            Toast.makeText(this, "You are neither male nor female.", Toast.LENGTH_SHORT).show()
        }

        val registerButton = findViewById<TextView>(R.id.redirect_login)
        registerButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}
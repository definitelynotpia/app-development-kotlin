package com.cs320.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.login_button)
        val registerButton = findViewById<TextView>(R.id.redirect_register)
        val forgotPasswordButton = findViewById<TextView>(R.id.forgot_password)

        loginButton.setOnClickListener {
            // TODO Auto-generated constructor stub
        }

        // Redirect to Register Activity
        registerButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        // Display Forgot Password Dialog
        forgotPasswordButton.setOnClickListener {
            Toast.makeText(this@Login, "Oh, you forgot? Sorry, can't help you!", Toast.LENGTH_SHORT).show()
        }


    }
}
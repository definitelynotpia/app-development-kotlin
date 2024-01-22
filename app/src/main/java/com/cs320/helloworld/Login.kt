package com.cs320.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.loginUsername)
        val password = findViewById<EditText>(R.id.loginPassword)
        val rememberMe = findViewById<CheckBox>(R.id.rememberMe)
        val loginButton = findViewById<Button>(R.id.login_button)

        rememberMe.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "We will remember your account", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "We won't remember your account", Toast.LENGTH_SHORT).show()
            }
        }

        loginButton.setOnClickListener {
            val usernameSubmitted = username.text.toString()
            val passwordSubmitted = password.text.toString()

            // Check if username and password are correct
            if (usernameSubmitted == "admin" && passwordSubmitted == "1234") {
                // Return success message
                Toast.makeText(
                    this,
                    "Login Successful: $usernameSubmitted, $passwordSubmitted",
                    Toast.LENGTH_SHORT
                ).show()

                // Redirect to Main Activity
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login Failed, create an account now!", Toast.LENGTH_SHORT)
                    .show()

                // Redirect to Register Activity
                val intent = Intent(this, Register::class.java)
                startActivity(intent)
            }
        }

        val registerButton = findViewById<TextView>(R.id.redirect_register)
        val forgotPasswordButton = findViewById<TextView>(R.id.forgot_password)

        // Redirect to Register Activity
        registerButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        // Display Forgot Password Dialog
        forgotPasswordButton.setOnClickListener {
            Toast.makeText(this@Login, "Oh, you forgot? Sorry, can't help you!", Toast.LENGTH_SHORT)
                .show()
        }


    }
}
package com.cs320.helloworld

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class Home : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Cart total price
        val prices = arrayOf(0, 0, 0) // (shirt, dress, jacket)
        var totalPrice = 0
        val priceTotal = findViewById<TextView>(R.id.priceTotal)

        // Price display
        val shirtPrice = findViewById<TextView>(R.id.shirtPrice)
        val dressPrice = findViewById<TextView>(R.id.dressPrice)
        val jacketPrice = findViewById<TextView>(R.id.jacketPrice)

        // Select shirt size
        val shirtSmall = findViewById<RadioButton>(R.id.shirtSize1)
        val shirtMedium = findViewById<RadioButton>(R.id.shirtSize2)
        val shirtLarge = findViewById<RadioButton>(R.id.shirtSize3)
        // Select dress size
        val dressSmall = findViewById<RadioButton>(R.id.dressSize1)
        val dressMedium = findViewById<RadioButton>(R.id.dressSize2)
        val dressLarge = findViewById<RadioButton>(R.id.dressSize3)
        // Select jacket size
        val jacketSmall = findViewById<RadioButton>(R.id.jacketSize1)
        val jacketMedium = findViewById<RadioButton>(R.id.jacketSize2)
        val jacketLarge = findViewById<RadioButton>(R.id.jacketSize3)

        // Payment validation
        val payment = findViewById<EditText>(R.id.paymentAmount)
        val checkoutButton = findViewById<Button>(R.id.checkoutButton)


        fun showTotalPrice(): Int {
            // Display total price
            totalPrice = (prices[0] + prices[1] + prices[2])
            val totalPriceString = totalPrice.toString()
            priceTotal.setText(totalPriceString)
            return totalPrice
        }


        // Set shirt price
        shirtSmall.setOnClickListener {
            shirtPrice.text = getString(R.string.small)
            prices[0] = 100
            showTotalPrice()
        }
        shirtMedium.setOnClickListener {
            shirtPrice.text = getString(R.string.medium)
            prices[0] = 150
            showTotalPrice()
        }
        shirtLarge.setOnClickListener {
            shirtPrice.text = getString(R.string.large)
            prices[0] = 200
            showTotalPrice()
        }

        // Set dress price
        dressSmall.setOnClickListener {
            dressPrice.text = getString(R.string.small)
            prices[1] = 100
            showTotalPrice()
        }
        dressMedium.setOnClickListener {
            dressPrice.text = getString(R.string.medium)
            prices[1] = 150
            showTotalPrice()
        }
        dressLarge.setOnClickListener {
            dressPrice.text = getString(R.string.large)
            prices[1] = 200
            showTotalPrice()
        }

        // Set jacket price
        jacketSmall.setOnClickListener {
            jacketPrice.text = getString(R.string.small)
            prices[2] = 100
            showTotalPrice()
        }
        jacketMedium.setOnClickListener {
            jacketPrice.text = getString(R.string.medium)
            prices[2] = 150
            showTotalPrice()
        }
        jacketLarge.setOnClickListener {
            jacketPrice.text = getString(R.string.large)
            prices[2] = 200
            showTotalPrice()
        }

        checkoutButton.setOnClickListener {
            val paymentSubmitted = payment.text.toString()
            val paymentAmount = paymentSubmitted.toDouble()

            if (paymentAmount < totalPrice) { // if payment is insufficient
                val  remainingAmount = totalPrice - paymentAmount
                Toast.makeText(this, "Your payment is insufficient. Please add ₱$remainingAmount", Toast.LENGTH_SHORT).show()
            } else if (paymentAmount == totalPrice.toDouble()) {
                Toast.makeText(this, "Thank you for your payment!", Toast.LENGTH_SHORT).show()
            } else { // if payment is sufficient
                val change = paymentAmount - totalPrice
                Toast.makeText(this, "Thank you for your payment! Your change is ₱$change", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
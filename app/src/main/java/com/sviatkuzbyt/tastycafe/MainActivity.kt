package com.sviatkuzbyt.tastycafe

import android.content.Intent
import android.content.res.Resources

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSalad = findViewById<TextView>(R.id.textSalad)
        val textDish = findViewById<TextView>(R.id.textDish)
        val textDrinks = findViewById<TextView>(R.id.textDrinks)
        val textDesert = findViewById<TextView>(R.id.textDesert)

        textSalad.setOnClickListener {
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 0)
            startActivity(myIntent)
        }

        textDish.setOnClickListener {
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 1)
            startActivity(myIntent)
        }

        textDrinks.setOnClickListener {
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 2)
            startActivity(myIntent)
        }

        textDesert.setOnClickListener {
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 3)
            startActivity(myIntent)
        }
    }
}
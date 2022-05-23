package com.sviatkuzbyt.tastycafe

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    val list = arrayOf(listMenu[1], listMenu[11], listMenu[16], listMenu[24], listMenu[6])
    val list2 = arrayOf(432, 3423, 98, 2323, 21)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSalad = findViewById<TextView>(R.id.textSalad)
        val textDish = findViewById<TextView>(R.id.textDish)
        val textDrinks = findViewById<TextView>(R.id.textDrinks)
        val textDesert = findViewById<TextView>(R.id.textDesert)

        val listsRecommendation = findViewById<RecyclerView>(R.id.listRecommendation)
        val adapter = ListsRecommendationAdapter(list)
        listsRecommendation.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listsRecommendation.layoutManager = layoutManager


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
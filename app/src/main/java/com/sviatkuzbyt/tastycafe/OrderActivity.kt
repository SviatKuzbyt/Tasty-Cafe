package com.sviatkuzbyt.tastycafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView



class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val list22 = listOrders

        val listtest = findViewById<ListView>(R.id.listtest)
        val adapter = ListsAdapter2(this, list22)
        listtest.adapter = adapter
    }
}
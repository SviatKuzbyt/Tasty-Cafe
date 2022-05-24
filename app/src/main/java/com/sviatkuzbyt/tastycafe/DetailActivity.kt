package com.sviatkuzbyt.tastycafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageProduct = findViewById<ImageView>(R.id.imageProduct)
        val titleProduct = findViewById<TextView>(R.id.titleProduct)
        val priceProduct = findViewById<TextView>(R.id.priceProduct)
        val weightProduct = findViewById<TextView>(R.id.weightProduct)
        val textInfo = findViewById<TextView>(R.id.textInfo)

        val id = intent.getIntExtra("id", 0)

        imageProduct.setImageResource(listMenu[id].image)
        titleProduct.text = listMenu[id].name
        priceProduct.text = listMenu[id].price.toString()
        weightProduct.text = listMenu[id].weight
        textInfo.text = getString(listMenu[id].info)

        val buttonUndoDetail = findViewById<ImageButton>(R.id.buttonUndoDetail)
        buttonUndoDetail.setOnClickListener { finish() }

    }
}
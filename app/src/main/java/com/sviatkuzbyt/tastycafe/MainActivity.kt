package com.sviatkuzbyt.tastycafe


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.ObjectOutputStream


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

        val intent2 = Intent(this, DetailActivity::class.java)
        listsRecommendation.addOnItemTouchListener(
            RecyclerItemClickListener(this,
                listsRecommendation,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        intent2.putExtra("id", list[position].id)
                        startActivity(intent2)
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        // do whatever
                    }
                })
        )

        listsRecommendation.setOnClickListener {
            Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", list[2].id)
            startActivity(intent)
        }

        textSalad.setOnClickListener {
            Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 0)
            startActivity(myIntent)
        }

        textDish.setOnClickListener {
            Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 1)
            startActivity(myIntent)
        }

        textDrinks.setOnClickListener {
            Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 2)
            startActivity(myIntent)
        }

        textDesert.setOnClickListener {
            Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
            val myIntent = Intent(this, CategoryActivity::class.java)
            myIntent.putExtra("group", 3)
            startActivity(myIntent)
        }

        setSupportActionBar(findViewById(R.id.toolbarMain))
        supportActionBar?.setDisplayShowTitleEnabled(false)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.order_btn -> {
            startActivity(Intent(this, CategoryActivity::class.java))
            true
        }
        R.id.search_btn -> {
            startActivity(Intent(this, CategoryActivity::class.java))
            true
        }
        else -> { super.onOptionsItemSelected(item) }
    }
}
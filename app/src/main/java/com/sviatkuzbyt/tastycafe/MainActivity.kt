package com.sviatkuzbyt.tastycafe


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    //Список рекомендацій
    val list = arrayOf(listMenu[1], listMenu[11], listMenu[16], listMenu[24], listMenu[6])

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Встановлення рекомендованого списка
        val listsRecommendation = findViewById<RecyclerView>(R.id.listRecommendation)
        val adapter = ListsRecommendationAdapter(list)
        listsRecommendation.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listsRecommendation.layoutManager = layoutManager

        //Функціонал рекомендованого списка
        val intentRec = Intent(this, DetailActivity::class.java)
        listsRecommendation.addOnItemTouchListener(
            RecyclerItemClickListener(this, listsRecommendation,
                object : RecyclerItemClickListener.OnItemClickListener {

                    override fun onItemClick(view: View?, position: Int) {
                        intentRec.putExtra("id", list[position].id)
                        startActivity(intentRec)
                    }
                    override fun onLongItemClick(view: View?, position: Int) { }
                })
        )

        //Встановлення шапки
        setSupportActionBar(findViewById(R.id.toolbarMain))
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    //Встановлення шапки
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Функціонал шапки
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.order_btn -> {
            startActivity(Intent(this, OrderActivity::class.java))
            true
        }
        R.id.search_btn -> {
            startActivity(Intent(this, SearchActivity::class.java))
            true
        }
        else -> { super.onOptionsItemSelected(item) }
    }

    //Функціонал кнопок категорій
    fun onClickSalad(v: View){
        Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
        val myIntent = Intent(this, CategoryActivity::class.java)
        myIntent.putExtra("group", 0)
        startActivity(myIntent)
    }
    fun onClickDish(v: View){
        Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
        val myIntent = Intent(this, CategoryActivity::class.java)
        myIntent.putExtra("group", 1)
        startActivity(myIntent)
    }
    fun onClickDrinks(v: View){
        Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
        val myIntent = Intent(this, CategoryActivity::class.java)
        myIntent.putExtra("group", 2)
        startActivity(myIntent)
    }
    fun onClickDesert(v: View){
        Toast.makeText(this, "Відкриття...", Toast.LENGTH_SHORT).show()
        val myIntent = Intent(this, CategoryActivity::class.java)
        myIntent.putExtra("group", 3)
        startActivity(myIntent)
    }
}
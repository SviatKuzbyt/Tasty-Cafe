package com.sviatkuzbyt.tastycafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        //Список і емблема
        val list: Array<MenuConstructor>
        val title: String

        //Відкриття категорії
        if (intent.getIntExtra("group", 0) == 0){
            list = arrayOf(listMenu[0], listMenu[1], listMenu[2], listMenu[3], listMenu[4], listMenu[5])
            title = "Салати та закуски"
        }
        else if (intent.getIntExtra("group", 0) == 1){
            list = arrayOf(listMenu[6], listMenu[7], listMenu[8], listMenu[9], listMenu[10], listMenu[11], listMenu[12])
            title = "Основні страви"
        }
        else if (intent.getIntExtra("group", 0) == 2){
            list = arrayOf(listMenu[13], listMenu[14], listMenu[15], listMenu[16], listMenu[17], listMenu[18], listMenu[19])
            title = "Напої"
        }
        else{
            list = arrayOf(listMenu[20], listMenu[21], listMenu[22], listMenu[23], listMenu[24], listMenu[25])
            title = "Десерти"
        }

        //Встановлення списку
        val adapter = ListsAdapter(this, list)
        val listCategory = findViewById<ListView>(R.id.list_category)
        listCategory.adapter = adapter

        //Функціонал списку
        listCategory.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", list[i].id)
            startActivity(intent)
        }

        //Встановлення шапки
        val toolbarCategory = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarCategory)
        setSupportActionBar(findViewById(R.id.toolbarCategory))
        supportActionBar?.title = title
        toolbarCategory.setNavigationOnClickListener { finish() }
        toolbarCategory.setTitleTextAppearance(this, R.style.ToolbarStyle)
    }
}
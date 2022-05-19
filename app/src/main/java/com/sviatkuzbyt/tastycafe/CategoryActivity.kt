package com.sviatkuzbyt.tastycafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val group = intent
        val listCategory = findViewById<ListView>(R.id.list_category)
        var adapter: ListsAdapter? = null
        var list: Array<menuСonstructor>? = null

        if (group.getIntExtra("group", 0) == 0){
            list = arrayOf(listMenu[0], listMenu[1], listMenu[2], listMenu[3], listMenu[4], listMenu[5])
        }
        else if (group.getIntExtra("group", 0) == 1){
            list = arrayOf(listMenu[6], listMenu[7], listMenu[8], listMenu[9], listMenu[10], listMenu[11], listMenu[12])
        }
        else if (group.getIntExtra("group", 0) == 2){
            list = arrayOf(listMenu[13], listMenu[14], listMenu[15], listMenu[16], listMenu[17], listMenu[18], listMenu[19])
        }
        else if (group.getIntExtra("group", 0) == 3){
            list = arrayOf(listMenu[20], listMenu[21], listMenu[22], listMenu[23], listMenu[24], listMenu[25])
        }

        adapter = list?.let { ListsAdapter(this, it) }
        listCategory.adapter = adapter
        listCategory.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", list!![i].id)
            startActivity(intent)
        }
    }
}
package com.sviatkuzbyt.tastycafe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

//глобальні змінні
var sumOrder: Int = 0
@SuppressLint("StaticFieldLeak")
var countOrder: TextView? = null
@SuppressLint("StaticFieldLeak")
var buttonOrder: Button? = null

class OrderActivity : AppCompatActivity() {

    private lateinit var adapter: ListOrderAdapter

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // перевернення списку 🙃
        if (listOrders.size > 1) listOrders.reverse()

        //встановлення суми
        sumOrder = 0
        listOrders.forEach{ sumOrder += it.price * it.number }
        //Заміна представлення
        countOrder = findViewById(R.id.textSumOrder)
        countOrder?.text = sumOrder.toString()

        //встановлення кнопки
        buttonOrder = findViewById(R.id.buttonOrder)
        if (listOrders.isEmpty()) buttonOrder?.background = getDrawable(R.drawable.button_add_disable)

        //Встановлення шапки
        val toolbarOrder = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarOrder) //представлення
        setSupportActionBar(findViewById(R.id.toolbarOrder)) //підтримка
        toolbarOrder.setNavigationOnClickListener { finish() } //кнопка назад
        toolbarOrder.setTitleTextAppearance(this, R.style.ToolbarStyle) //стиль

        //Встановлення списку
        val listOrderView = findViewById<ListView>(R.id.listOrderView)
        adapter = ListOrderAdapter(this, listOrders)
        listOrderView.adapter = adapter

        //кнопка "Замовлення"
        buttonOrder?.setOnClickListener {
            if (listOrders.isNotEmpty()){
                val inet = Intent(this, QRcodeActivity::class.java)
                startActivity(inet)
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.order_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Кнопка "Очистити"
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.deleteOrdersBtn -> {
            if (listOrders.isNotEmpty()){
                //Будування вікна
                val windowBuild = AlertDialog.Builder(ContextThemeWrapper(this, R.style.MyAlertDialog))
                windowBuild.setTitle(R.string.deleteOrdersWarming)

                //Функціонал
                windowBuild.setPositiveButton(R.string.yes){ _, _ ->
                    listOrders.forEach { if (it.number > 1) it.number = 1 } //відкат кількості
                    listOrders.clear() //очищення
                    adapter.notifyDataSetInvalidated() //оновлення
                    countOrder?.text = "0" //зміна представлення суми
                    buttonOrder?.background = getDrawable(R.drawable.button_add_disable) //зміна кнопки
                }

                //Функціонал закриття
                windowBuild.setNegativeButton(R.string.no) { _, _ -> closeContextMenu() }

                //Встановлення вікн
                val windowPlay = windowBuild.create()
                windowPlay.show()
            }
            true
        }
        else -> { super.onOptionsItemSelected(item) }
    }

    // перевернення списку 🙃
    override fun onDestroy() {
        super.onDestroy()
        if (listOrders.size > 1) listOrders.reverse()
    }
}
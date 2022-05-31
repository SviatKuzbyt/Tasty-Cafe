package com.sviatkuzbyt.tastycafe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {

    //Змінни для роботи
    private var addButton: Button? = null
    private var orderText: TextView? = null
    private var divider: View? = null
    private val params = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Встановлення представлень
        val imageProduct = findViewById<ImageView>(R.id.imageProduct)
        val titleProduct = findViewById<TextView>(R.id.titleProduct)
        val priceProduct = findViewById<TextView>(R.id.priceProduct)
        val weightProduct = findViewById<TextView>(R.id.weightProduct)
        val textInfo = findViewById<TextView>(R.id.textInfo)
        val buttonUndoDetail = findViewById<ImageButton>(R.id.buttonUndoDetail)
        addButton = findViewById(R.id.buttonAdd)
        orderText = findViewById(R.id.orderText)
        divider = findViewById(R.id.divider)

        //Заміна представлень
        val id = intent.getIntExtra("id", 0)

        imageProduct.setImageResource(listMenu[id].image)
        titleProduct.text = listMenu[id].name
        priceProduct.text = listMenu[id].price.toString()
        weightProduct.text = listMenu[id].weight
        textInfo.text = getString(listMenu[id].info)

        //Кнопка назад
        buttonUndoDetail.setOnClickListener { finish() }

        //встановлення кнопки
        if (listMenu[id] in listOrders){ setButton(true) }

        //Функціонал кнопки
        addButton?.setOnClickListener {
            if (listMenu[id] in listOrders){ //Видалення замовлення
                setButton(false)
                listOrders.remove(listMenu[id])
            }
            else{ //Додавання замовлення
                setButton(true)
                listOrders.add(listMenu[id])
            }
        }

        //Функціонал
        orderText?.setOnClickListener { startActivity(Intent(this, OrderActivity::class.java)) }
    }

    //Встановлення вигляду кнопки
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setButton(enabled: Boolean){
        if(enabled){
            addButton?.background = getDrawable(R.drawable.button_add_disable)
            orderText?.visibility = View.VISIBLE
            addButton?.text = getString(R.string.delete_order_btn)

            params.addRule(RelativeLayout.BELOW, R.id.orderText)
            divider?.layoutParams = params
        }
        else{
            addButton?.background = getDrawable(R.drawable.button_add)
            orderText?.visibility = View.GONE
            addButton?.text = getString(R.string.get_order)

            params.addRule(RelativeLayout.BELOW, R.id.buttonAdd)
            divider?.layoutParams = params
        }
    }
}
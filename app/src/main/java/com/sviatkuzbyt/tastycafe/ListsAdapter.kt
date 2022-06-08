package com.sviatkuzbyt.tastycafe

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView


class ListsAdapter (private val context: Activity, private val title: Array<MenuConstructor>)
    : ArrayAdapter<MenuConstructor>(context, R.layout.list_category, title)  {
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_category, null, true)

        //Змінні представлень
        val titleText = rowView.findViewById(R.id.titleCategory) as TextView
        val imageView = rowView.findViewById(R.id.imageCategory) as ImageView
        val priceText = rowView.findViewById(R.id.priceCategory) as TextView
        val weightText = rowView.findViewById(R.id.weightCategory) as TextView

        //Встановлення представлень
        titleText.text = title[position].name
        imageView.setImageResource(title[position].image)
        priceText.text = title[position].price.toString()
        weightText.text = title[position].weight

        return rowView
    }
}



//Тимчасово
class ListOrderAdapter (private val context: Activity, private val title: MutableList<MenuConstructor>)
    : ArrayAdapter<MenuConstructor>(context, R.layout.list_order, title)  {
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        //Представлення
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_order, null, true)
        val titleText = rowView.findViewById(R.id.titleOrder) as TextView
        val imageView = rowView.findViewById(R.id.imageOrder) as ImageView
        val priceText = rowView.findViewById(R.id.priceOrder) as TextView
        val weightText = rowView.findViewById(R.id.weightOrder) as TextView
        val btnRemove = rowView.findViewById(R.id.btn_add_remove) as ImageButton
        val btnAdd = rowView.findViewById(R.id.btn_add_num) as ImageButton
        val delete = rowView.findViewById(R.id.deleteOrder) as TextView
        val num = rowView.findViewById(R.id.text_num) as TextView

        //Заміна представлкнь
        titleText.text = title[position].name
        imageView.setImageResource(title[position].image)
        priceText.text = title[position].price.toString()
        weightText.text = title[position].weight
        num.text = title[position].number.toString()

        //кнопка видалення кількості замовлення
        btnRemove.setOnClickListener {
            if(title[position].number > 1){
                title[position].number -- //видалення в списку
                num.text = title[position].number.toString() //заміна представлення
                sumOrder -= title[position].price //видалення з суми
                countOrder?.text = sumOrder.toString() //заміна представлення суми
            }

        }

        //кнопка додання кількості замовлення
        btnAdd.setOnClickListener {
            if(title[position].number < 10){
                title[position].number ++
                num.text = title[position].number.toString()
                sumOrder += title[position].price
                countOrder?.text = sumOrder.toString()
            }

        }

        //кнопка видалення  замовлення
        delete.setOnClickListener {
            sumOrder -= title[position].price * title[position].number //видалення з суми
            if (listOrders[position].number > 1) listOrders[position].number = 1 //відкат кількості
            listOrders.remove(title[position]) //видалення
            notifyDataSetInvalidated() //оновлення вигляду
            countOrder?.text = sumOrder.toString() //зміна представлення суми
            if (listOrders.isEmpty())  //зміна вигляду кнопки
                buttonOrder?.background = getDrawable(context, R.drawable.button_add_disable)
        }

        return rowView
    }
}

class ListsRecommendationAdapter(private val dataSet: Array<MenuConstructor>) :
    RecyclerView.Adapter<ListsRecommendationAdapter.ViewHolder>() {

    //Змінні представлень
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val img: ImageView
        val price: TextView

        init {
            title = view.findViewById(R.id.textRecommendation)
            img = view.findViewById(R.id.imageViewRecommendation)
            price = view.findViewById(R.id.priceRecommendation)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_recommendation, viewGroup, false)
        return ViewHolder(view)
    }

    //Встановлення представлень
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataSet[position].name
        viewHolder.img.setImageResource(dataSet[position].image)
        viewHolder.price.text = dataSet[position].price.toString()
    }

    override fun getItemCount() = dataSet.size
}
package com.sviatkuzbyt.tastycafe

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
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
class ListsAdapter2 (private val context: Activity, private val title: MutableList<MenuConstructor>)
    : ArrayAdapter<MenuConstructor>(context, R.layout.list_category, title)  {
    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_category, null, true)
        val titleText = rowView.findViewById(R.id.titleCategory) as TextView
        val imageView = rowView.findViewById(R.id.imageCategory) as ImageView
        val priceText = rowView.findViewById(R.id.priceCategory) as TextView
        val weightText = rowView.findViewById(R.id.weightCategory) as TextView
        titleText.text = title[position].name
        imageView.setImageResource(title[position].image)
        priceText.text = title[position].price.toString()
        weightText.text = title[position].weight
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
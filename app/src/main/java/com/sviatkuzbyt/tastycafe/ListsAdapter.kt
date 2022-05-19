package com.sviatkuzbyt.tastycafe

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListsAdapter (private val context: Activity, private val title: Array<menuСonstructor>)
    : ArrayAdapter<menuСonstructor>(context, R.layout.list_category, title)  {
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

class ListsRecommendationAdapter (private val context: Activity, private val title: Array<menuСonstructor>)
    : ArrayAdapter<menuСonstructor>(context, R.layout.list_recommendation, title)  {
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_recommendation, null, true)

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
package com.sviatkuzbyt.tastycafe

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView


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

class ListsRecommendationAdapter(private val dataSet: Array<menuСonstructor>) :
    RecyclerView.Adapter<ListsRecommendationAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val img: ImageView
        val price: TextView

        init {
            // Define click listener for the ViewHolder's View.
            title = view.findViewById(R.id.textRecommendation)
            img = view.findViewById(R.id.imageViewRecommendation)
            price = view.findViewById(R.id.priceRecommendation)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_recommendation, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.title.text = dataSet[position].name
        viewHolder.img.setImageResource(dataSet[position].image)
        viewHolder.price.text = dataSet[position].price.toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
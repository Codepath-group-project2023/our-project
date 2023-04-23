package com.example.codepathproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter(private var imagelist: List<String>, private var namelist: List<String>, private var categorylist: List<String>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    //** these r for being able to click on item in recycler view
    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }
    //**



    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        var image: ImageView
        var user: TextView
        var category: TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            image = view.findViewById(R.id.mealpicture)
            user = view.findViewById(R.id.recipename)
            category = view.findViewById(R.id.categories)

            //this is for being able to click on an item in recycler view
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview, parent, false)

        return ViewHolder(view, mListener) //passing mListener to be able to click on an item in recycler view
    }

    override fun getItemCount() = imagelist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(imagelist[position])
            .centerCrop()
            .into(holder.image)

        holder.user.text = namelist[position]
        holder.category.text = "Category: " + categorylist[position]
    }


}
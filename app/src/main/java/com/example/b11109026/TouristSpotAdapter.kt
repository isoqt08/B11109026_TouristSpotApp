package com.example.b11109026

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TouristSpotAdapter(
    private val touristSpots: List<TouristSpot>,
    private val clickListener: (TouristSpot) -> Unit
) : RecyclerView.Adapter<TouristSpotAdapter.TouristSpotViewHolder>() {

    class TouristSpotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristSpotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tourist_spot, parent, false)
        return TouristSpotViewHolder(view)
    }

    override fun onBindViewHolder(holder: TouristSpotViewHolder, position: Int) {
        val touristSpot = touristSpots[position]
        holder.imageView.setImageResource(touristSpot.imageResource)
        holder.textView.text = touristSpot.name
        holder.itemView.setOnClickListener { clickListener(touristSpot) }
    }

    override fun getItemCount() = touristSpots.size
}
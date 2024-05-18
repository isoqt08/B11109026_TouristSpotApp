package com.example.b11109026

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val touristSpots = DataSource.getTouristSpots()
        val adapter = TouristSpotAdapter(touristSpots) { touristSpot ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", touristSpot.name)
            intent.putExtra("description", touristSpot.description)
            intent.putExtra("imageResource", touristSpot.imageResource)
            intent.putExtra("locationLink", touristSpot.locationLink)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}

package com.example.b11109026

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get the data from the intent
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val imageResource = intent.getIntExtra("imageResource", 0)
        val locationLink = intent.getStringExtra("locationLink")

        // Find the views in the layout
        val nameTextView: TextView = findViewById(R.id.detail_name)
        val descriptionTextView: TextView = findViewById(R.id.detail_description)
        val imageView: ImageView = findViewById(R.id.detail_image)
        val viewLocationButton: TextView = findViewById(R.id.view_location_button)
        val backButton: TextView = findViewById(R.id.back_button)

        // Set the data to the views
        nameTextView.text = name
        descriptionTextView.text = description
        imageView.setImageResource(imageResource)

        // Set the button click listener to view location
        viewLocationButton.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(locationLink))
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(this@DetailActivity, "Google Maps app not found", Toast.LENGTH_SHORT).show()
            }
        }

        // Set click listener for back button
        backButton.setOnClickListener {
            finish() // Finish current activity to go back
        }
    }
}

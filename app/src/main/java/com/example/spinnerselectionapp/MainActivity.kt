package com.example.spinnerselectionapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cities = arrayOf("Mumbai", "Delhi", "Bangalore", "Hyderabad", "Chennai", "Kolkata", "Pune", "Jaipur", "Jammu")
        val spinnerCities = findViewById<Spinner>(R.id.spinnerCities)
        val btnShowSelection = findViewById<Button>(R.id.btnShowSelection)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val adapter = ArrayAdapter(this, R.layout.spinner_item, cities)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerCities.adapter = adapter

        btnShowSelection.setOnClickListener {
            val selectedCity = spinnerCities.selectedItem.toString()
            tvResult.text = "Selected City: $selectedCity"
        }
    }
}
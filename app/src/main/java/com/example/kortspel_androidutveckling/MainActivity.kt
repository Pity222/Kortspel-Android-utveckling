package com.example.kortspel_androidutveckling

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// döp rätt namn
        // Hitta knappen "Starta spelet"
        val btnStart = findViewById<MaterialButton>(R.id.btnStartGame)

        // När man trycker → gå till spelskärmen
        btnStart.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}

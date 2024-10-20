package com.principe.cuellar.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)

        // Ajustes para edge to edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los componentes
        val cardView: CardView = findViewById(R.id.cardView)
        val btnMostrar: Button = findViewById(R.id.btnMostrar)
        val btnOcultar: Button = findViewById(R.id.btnOcultar)

        // Funcionalidad para mostrar el CardView
        btnMostrar.setOnClickListener {
            cardView.visibility = View.VISIBLE
        }

        // Funcionalidad para ocultar el CardView
        btnOcultar.setOnClickListener {
            cardView.visibility = View.GONE
        }
    }
}

package com.principe.cuellar.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.principe.cuellar.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {


    private val NAME_KEY = "NAME_KEY"
    private val PHONE_KEY = "PHONE_KEY"
    private val PRODUCTS_KEY = "PRODUCTS_KEY"
    private val CITY_KEY = "CITY_KEY"
    private val ADDRESS_KEY = "ADDRESS_KEY"


    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        observeButtons()
    }

    private fun observeButtons() {

        binding.btnRegister.setOnClickListener {
            goDetailActivity()
        }
    }

    private fun goDetailActivity() {

        val name = binding.edtName.text.toString()
        val phone = binding.edtPhone.text.toString()
        val products = binding.edtProducts.text.toString()
        val city = binding.edtCity.text.toString()
        val address = binding.edtAddress.text.toString()


        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(NAME_KEY, name)
        intent.putExtra(PHONE_KEY, phone)
        intent.putExtra(PRODUCTS_KEY, products)
        intent.putExtra(CITY_KEY, city)
        intent.putExtra(ADDRESS_KEY, address)


        startActivity(intent)
    }
}

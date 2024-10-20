package com.principe.cuellar.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.principe.cuellar.laboratoriocalificado02.databinding.ActivityDetailBinding
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    private val NAME_KEY = "NAME_KEY"
    private val PHONE_KEY = "PHONE_KEY"
    private val PRODUCTS_KEY = "PRODUCTS_KEY"
    private val CITY_KEY = "CITY_KEY"
    private val ADDRESS_KEY = "ADDRESS_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        setInformation(intent.extras)


        observeButtons(intent.extras)
    }


    private fun setInformation(bundle: Bundle?) {
        if (bundle != null) {
            binding.tvName.text = "Nombre Cliente: ${bundle.getString(NAME_KEY)}"
            binding.tvPhone.text = "Número Cliente: ${bundle.getString(PHONE_KEY)}"
            binding.tvProducts.text = "Productos: ${bundle.getString(PRODUCTS_KEY)}"
            binding.tvLocation.text = "Dirección: ${bundle.getString(ADDRESS_KEY)}"
        }
    }


    private fun observeButtons(bundle: Bundle?) {
        binding.btnCall.setOnClickListener {
            goDial(bundle)
        }

        binding.btnWhatsapp.setOnClickListener {
            goWsp(bundle)
        }

        binding.btnMaps.setOnClickListener {
            goMaps(bundle)
        }
    }


    private fun goDial(bundle: Bundle?) {
        val phone = bundle?.getString(PHONE_KEY)
        if (!phone.isNullOrEmpty()) {
            val intentDial = Intent(Intent.ACTION_DIAL)
            intentDial.data = Uri.parse("tel:$phone")
            startActivity(intentDial)
        } else {
            Toast.makeText(this, "Número de teléfono no disponible", Toast.LENGTH_SHORT).show()
        }
    }


    private fun goWsp(bundle: Bundle?) {
        val phone = "+51${bundle?.getString(PHONE_KEY)}"
        val message = "Hola ${bundle?.getString(NAME_KEY)}, tus productos: ${bundle?.getString(PRODUCTS_KEY)} están en camino a la dirección: ${bundle?.getString(ADDRESS_KEY)}."

        val intentWsp = Intent(Intent.ACTION_VIEW)
        intentWsp.data = Uri.parse("https://wa.me/$phone?text=$message")
        startActivity(intentWsp)
    }


    private fun goMaps(bundle: Bundle?) {
        val address = bundle?.getString(ADDRESS_KEY)
        if (!address.isNullOrEmpty()) {
            val gmmIntentUri = Uri.parse("geo:0,0?q=$address")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "Dirección no disponible", Toast.LENGTH_SHORT).show()
        }
    }
}

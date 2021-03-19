package com.example.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.databinding.ActivityMainBinding
import com.example.customspinner.databinding.ActivitySelectCountryBinding

class SelectCountryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectCountryBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectCountryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




    }
}
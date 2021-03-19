package com.example.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.country.CountryAdapter
import com.example.customspinner.databinding.ActivityMainBinding
import com.example.customspinner.databinding.ActivitySelectCountryBinding

class SelectCountryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectCountryBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectCountryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // 스피너 설정부분
        val countrySpinnerAdapter = CountryAdapter(this)
        binding.sCountry.adapter = countrySpinnerAdapter

//        binding.sCountry.item

        // 스피너 설정 부분
//        val kneeDiseaseAdapter = context?.let { CustomSingleSpinnerAdapter(it, items) }
//        binding.spinner.adapter = kneeDiseaseAdapter


    }
}
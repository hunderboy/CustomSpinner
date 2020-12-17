package com.example.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.databinding.ActivityCustomSpinnerBinding
import com.example.customspinner.databinding.ActivityMainBinding


class CustomSpinnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomSpinnerBinding


    private val items = arrayOf("UK","NL","DE","SE")


    // country spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomSpinnerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료


        // 스피너 설정부분
        val countrySpinnerAdapter = CountryAdapter(this)
        binding.sCountry.adapter = countrySpinnerAdapter


    }


}
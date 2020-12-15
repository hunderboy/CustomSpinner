package com.example.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val items = arrayOf("아이템0","아이템1","아이템2","아이템3","아이템4")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료


        val myAdapter = SpinnerAdapter(this, items)
        binding.spinner.adapter = myAdapter


    }


}
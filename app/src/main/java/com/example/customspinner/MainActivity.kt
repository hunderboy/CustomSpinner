package com.example.customspinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val items = arrayOf("데이터0","아이템1","데이터2","아이템3","화이팅4")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // 스피너 설정부분
        val myAdapter = SpinnerAdapter(this, items)
        binding.spinner.adapter = myAdapter


        binding.button1.setOnClickListener {
            val intent = Intent(this, CustomSpinnerActivity::class.java)
            startActivity(intent)
        }


    }


}
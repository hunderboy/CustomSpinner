package com.example.customspinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.customspinner.country.CustomSpinnerActivity
import com.example.customspinner.databinding.ActivityMainBinding
import com.example.customspinner.service.ServiceActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val items = arrayOf("데이터0","아이템1","데이터2","아이템3","화이팅4")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        // 버튼 설정 부분
        binding.button1.setOnClickListener {
//            val intent = Intent(this, CustomSpinnerActivity::class.java)
//            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this, SelectCountryActivity::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this, CustomDialogActivity::class.java)
            startActivity(intent)
        }



    }

}
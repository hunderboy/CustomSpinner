package com.example.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.databinding.ActivityCustomDialogBinding
import com.example.customspinner.databinding.ActivityMainBinding
import com.example.customspinner.fragment.CustomDialogFragment

class CustomDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomDialogBinding


    // 운동 전 다이얼로그
    val dialogFragmentExample = CustomDialogFragment()

    // 운동 후 다이얼로그


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 운동 전 다이얼로그
        binding.buttonDialog.setOnClickListener {
//            CustomDialog(context = this).myDig()
            dialogFragmentExample.show(supportFragmentManager, null)
        }
        // 운동 후 다이얼로그
        binding.buttonDialog2.setOnClickListener {
            dialogFragmentExample.show(supportFragmentManager, null)
        }

    }

}
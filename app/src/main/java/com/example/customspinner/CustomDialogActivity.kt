package com.example.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.databinding.ActivityCustomDialogBinding
import com.example.customspinner.databinding.ActivityMainBinding
import com.example.customspinner.fragment.CustomDialogFragment

class CustomDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomDialogBinding


    // 슬라이드 이동을 위해 전역변수로 설정
    val dialogFragmentExample = CustomDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonDialog.setOnClickListener {
//            CustomDialog(context = this).myDig()

            dialogFragmentExample.show(supportFragmentManager, null)



        }
    }

}
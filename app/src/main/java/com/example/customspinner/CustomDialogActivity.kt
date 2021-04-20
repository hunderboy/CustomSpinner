package com.example.customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customspinner.databinding.ActivityCustomDialogBinding
import com.example.customspinner.databinding.ActivityMainBinding

class CustomDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonDialog.setOnClickListener {
//            CustomDialog(context = this).myDig()

            val dialogFragmentExample = CustomDialogFragment()
            dialogFragmentExample.show(supportFragmentManager, null)

        }
    }

}
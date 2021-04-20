package com.example.customspinner.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.customspinner.CustomDialogActivity
import com.example.customspinner.R
import com.example.customspinner.databinding.FragmentPainBinding
import com.example.customspinner.databinding.FragmentPainKillerBinding


class PainKillerFragment : Fragment() {
    private var _binding: FragmentPainKillerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPainKillerBinding.inflate(inflater, container, false)
        val view = binding.root

        // 페이지 이동
        binding.imageButtonPrevious.setOnClickListener(){
            (activity as CustomDialogActivity).dialogFragmentExample.slidePreviousPage()
        }

        binding.imageButtonYes.setOnClickListener(){
            Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show()
        }
        binding.imageButtonNo.setOnClickListener(){
            Toast.makeText(context, "No", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSubmit.setOnClickListener(){
            (activity as CustomDialogActivity).dialogFragmentExample.slideNextPage()
        }


        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
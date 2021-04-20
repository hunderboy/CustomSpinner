package com.example.customspinner.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customspinner.CustomDialogActivity
import com.example.customspinner.R
import com.example.customspinner.databinding.FragmentEvaluationBinding
import com.example.customspinner.databinding.FragmentPainBinding

class EvaluationFragment : Fragment() {
    private var _binding: FragmentEvaluationBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEvaluationBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.imageButtonHard.setOnClickListener(){
            (activity as CustomDialogActivity).dialogFragmentExample.slidePreviousPage()
        }

        return view
    }


}
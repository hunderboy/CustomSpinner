package com.example.customspinner.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customspinner.R
import com.example.customspinner.databinding.FragmentPainBinding


class PainFragment : Fragment() {
    private var _binding: FragmentPainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPainBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
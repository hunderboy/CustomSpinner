package com.example.customspinner.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customspinner.CustomDialogActivity
import com.example.customspinner.R
import com.example.customspinner.databinding.FragmentPainBinding
import com.example.customspinner.databinding.FragmentQuestionPainAfterExerciseBinding

class QuestionPainAfterExerciseFragment : Fragment() {
    private var _binding: FragmentQuestionPainAfterExerciseBinding? = null
    private val binding get() = _binding!!
    private val TAG = "QuestionPainAfterExerciseFragment : "



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionPainAfterExerciseBinding.inflate(inflater, container, false)
        val view = binding.root


        // 페이지 이동
        binding.buttonNext.setOnClickListener(){
            (activity as CustomDialogActivity).afterExerciseFragment.slideNextPage()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.e(TAG+"onDestroyView","호출됨")

    }
}
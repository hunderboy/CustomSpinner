package com.example.customspinner.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.customspinner.CustomDialogActivity
import com.example.customspinner.R
import com.example.customspinner.databinding.FragmentEvaluationBinding
import com.example.customspinner.databinding.FragmentPainBinding

class EvaluationFragment : Fragment() {
    private var _binding: FragmentEvaluationBinding? = null
    private val binding get() = _binding!!


    /** 운동평가 타입 변수
     * 없음 = 선택된 데이터 없음
     * 어려워요 = "어려워요" 선택됨
     * 할만해요 = "할만해요" 선택됨
     * 쉬워요 = "쉬워요" 선택됨
     */
    private var exerciseEvaluationType: String = "없음" // 선택된 데이터 없음



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEvaluationBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.imageButtonPrevious.setOnClickListener(){
            (activity as CustomDialogActivity).afterExerciseFragment.slidePreviousPage()
        }

        // 어려워요
        binding.imageButtonHard.setOnClickListener(){
            // '어려워요' 민트색으로
            binding.imageButtonHard.setImageResource(R.drawable.ic_evaluation_hard_mint)
            // '할만해요','쉬워요' 회색으로
            binding.imageButtonEasy.setImageResource(R.drawable.ic_evaluation_easy_black)
            binding.imageButtonNormal.setImageResource(R.drawable.ic_evaluation_normal_black)
            exerciseEvaluationType = "어려워요"
        }
        // 할만해요
        binding.imageButtonNormal.setOnClickListener(){
            // '할만해요' 민트색으로
            binding.imageButtonNormal.setImageResource(R.drawable.ic_evaluation_normal_mint)
            // '어려워요','쉬워요' 회색으로
            binding.imageButtonHard.setImageResource(R.drawable.ic_evaluation_hard_black)
            binding.imageButtonEasy.setImageResource(R.drawable.ic_evaluation_easy_black)
            exerciseEvaluationType = "할만해요"
        }
        // 쉬워요
        binding.imageButtonEasy.setOnClickListener(){
            // '쉬워요' 민트색으로
            binding.imageButtonEasy.setImageResource(R.drawable.ic_evaluation_easy_mint)
            // '할만해요','어려워요' 회색으로
            binding.imageButtonNormal.setImageResource(R.drawable.ic_evaluation_normal_black)
            binding.imageButtonHard.setImageResource(R.drawable.ic_evaluation_hard_black)
            exerciseEvaluationType = "쉬워요"
        }
        binding.buttonSubmit.setOnClickListener(){
            if(exerciseEvaluationType == "없음"){
                Toast.makeText(context, "복용여부를 설정해주세요.", Toast.LENGTH_SHORT).show()
            }else{
                (activity as CustomDialogActivity).afterExerciseFragment.dismiss()
            }
        }


        return view
    }


}
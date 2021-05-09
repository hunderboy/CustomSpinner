package com.example.customspinner.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.customspinner.CustomDialogActivity
import com.example.customspinner.R
import com.example.customspinner.databinding.FragmentAfterExerciseBinding
import com.example.customspinner.databinding.FragmentCustomDialogBinding

class AfterExerciseFragment : DialogFragment() {
    private var _binding: FragmentAfterExerciseBinding? = null
    private val binding get() = _binding!!


    // 통증, 난이도 관련 ViewPager에 포함될 Fragments
    private val questionPainAfterExerciseFragment = QuestionPainAfterExerciseFragment() // 통증 질문
    private val evaluationFragment = EvaluationFragment()   // 난이도 질문
    private val FragList = arrayOf(
        questionPainAfterExerciseFragment,
        evaluationFragment,
    )


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAfterExerciseBinding.inflate(inflater, container, false)
        val view = binding.root



        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog?.window?.setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
        )

        val pagerAdapter = PagerAdapter((activity as CustomDialogActivity))
        binding.viewPager2Container.isUserInputEnabled = false  // 스크롤 비허용
        binding.viewPager2Container.adapter = pagerAdapter

        return view
    }




    // ViewPager2 어댑터 설정
    inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int { // 페이지수
            return FragList.size
        }
        override fun createFragment(position: Int): Fragment { // 페이지 Fragment 생성
            return when(position){ // 포지션에 따른 다른 페이지 Fragment 전달
                0 -> QuestionPainAfterExerciseFragment()
                1 -> EvaluationFragment()
                else -> EvaluationFragment()
            }
        }
    }


    private fun getCurrentItemPosition(i: Int): Int {
        Log.e("현재",""+binding.viewPager2Container.currentItem.toString())
        return binding.viewPager2Container.currentItem + i
    }
    fun slideNextPage() {
        val next = getCurrentItemPosition(+1)

        if (next < binding.viewPager2Container.adapter?.itemCount ?: (+0)) {
            // 다음 페이지 이동
            binding.viewPager2Container.currentItem = next
        } else { // 마지막 화면
            Toast.makeText(context, "마지막 화면입니다.", Toast.LENGTH_SHORT).show()
        }
    }
    fun slidePreviousPage() {
        val previous = getCurrentItemPosition(-1)

        if (previous >= 0) {
            // 이전 페이지 이동
            binding.viewPager2Container.currentItem = previous
        } else { // 처음 화면
            Toast.makeText(context, "처음 화면입니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
package com.example.customspinner.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.customspinner.CustomDialogActivity
import com.example.customspinner.R
import com.example.customspinner.databinding.FragmentCustomDialogBinding
import com.example.customspinner.databinding.FragmentPainBinding

class CustomDialogFragment : DialogFragment() {
    private var _binding: FragmentCustomDialogBinding? = null
    private val binding get() = _binding!!

    // 상단 개인 일,주,월 데이터 관련 ViewPager에 포함될 Fragments
    private val painFragment = PainFragment()
    private val painKillerFragment = PainKillerFragment()
    val dataFragList = arrayOf(
        painFragment,
        painKillerFragment,
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomDialogBinding.inflate(inflater, container, false)
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
            return dataFragList.size
        }
        override fun createFragment(position: Int): Fragment { // 페이지 Fragment 생성
            return when(position){ // 포지션에 따른 다른 페이지 Fragment 전달
                0 -> PainFragment()
                1 -> PainKillerFragment()
                else -> PainFragment()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
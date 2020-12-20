package com.example.customspinner.service

import android.R
import android.os.Bundle
import android.view.View
import android.widget.ListPopupWindow
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.customspinner.databinding.ActivityServiceBinding


class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding
    private val items = arrayListOf("Mercury", "Venus", "Earth", "Mars", "Caramels", "전방십자인대손상", "전방십자인대 재건술")
    private val intItems = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")


    private val surveyItems = arrayListOf(
            "퇴행성 관절염", "인대손상", "연골판 손상", "슬개골 탈구", "연골손상",
            "전방무릎통증증후군", "연골연화증", "대퇴슬개통증증후군", "추벽증후군", "슬개건염", "햄스트링건염", "대퇴사두건염", "슬와건염",
            "골절", "기타"
    )

    private val weekItems = arrayListOf("0회", "1회", "2회", "3회", "4회", "5회", "6회", "7회")
    private val dayItems = arrayListOf("30분", "1시간", "2시간", "3시간", "4시간", "4시간 이상")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 버튼 클릭
        binding.buttonData.setOnClickListener {
            // 무릎통증
//            val selectedData = binding.spinnerService2.selectedItem.toString()
//            Toast.makeText(this, "선택된 DATA = $selectedData", Toast.LENGTH_SHORT).show()

//            // 주
//            val selectedData = binding.spinnerServiceWeek.selectedItem.toString()
//            Toast.makeText(this, "선택된 DATA = $selectedData", Toast.LENGTH_SHORT).show()
            // 하루
            val selectedData = binding.spinnerServiceDay.selectedItem.toString()
            Toast.makeText(this, "선택된 DATA = $selectedData", Toast.LENGTH_SHORT).show()
        }


        // 스피너 설정 부분
        val myAdapter = ServiceCustomSpinnerAdapter(this, items)
        binding.spinnerService.adapter = myAdapter

        // 무릎통증 스피너 설정 부분
        val myAdapter2 = ServiceLayoutAdapter(this, surveyItems)
        binding.spinnerService2.adapter = myAdapter2

        // 주 스피너
        val weekAdapter = WeekSpinnerAdapter(this, weekItems)
        binding.spinnerServiceWeek.adapter = weekAdapter

        // 하루 스피너
        val dayAdapter = DaySpinnerAdapter(this, dayItems)
        binding.spinnerServiceDay.adapter = dayAdapter



//        try {
//            val popup: Field = Spinner::class.java.getDeclaredField("mPopup")
//            popup.isAccessible = true
//            val window: ListPopupWindow = popup.get(binding.spinnerService2) as ListPopupWindow
//            window.height = 100 //pixel
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }












    }





}
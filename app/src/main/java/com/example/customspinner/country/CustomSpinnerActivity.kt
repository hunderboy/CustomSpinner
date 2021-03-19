package com.example.customspinner.country

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.customspinner.R
import com.example.customspinner.databinding.ActivityCustomSpinnerBinding


class CustomSpinnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomSpinnerBinding


    private val items = arrayOf("UK","NL","DE","SE")


    // country spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomSpinnerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) // 뷰 바인딩 적용 완료


        // 스피너 설정부분
//        val countrySpinnerAdapter = CountryAdapter(this)
//        binding.sCountry.adapter = countrySpinnerAdapter




        // 어댑터 생성
        val workingAdapter = object : ArrayAdapter<String>(this, R.layout.item_default_spinner) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val v = super.getView(position, convertView, parent)

                if (position == count) {
                    //마지막 포지션의 textView 를 힌트 용으로 사용합니다.
                    (v.findViewById<View>(R.id.tvItemSpinner) as TextView).text = ""
                    //아이템의 마지막 값을 불러와 hint로 추가해 줍니다.
                    (v.findViewById<View>(R.id.tvItemSpinner) as TextView).hint = getItem(count)
                }

                return v
            }
            override fun getCount(): Int {
                //마지막 아이템은 힌트용으로만 사용하기 때문에 getCount에 1을 빼줍니다.
                return super.getCount() - 1
            }


        }


//아이템을 추가해 줍니다.
        workingAdapter.addAll(items.toMutableList())
//힌트로 사용할 문구를 마지막 아이템에 추가해 줍니다.
        workingAdapter.add("제목입니다.")
        binding.spinnerWorking.adapter = workingAdapter

//스피너 초기값을 마지막 아이템으로 설정해 줍니다. (마지막 아이템이 힌트 이기 때문이죠)
        binding.spinnerWorking.setSelection(workingAdapter.count)

        binding.spinnerWorking.dropDownVerticalOffset = dipToPixels(45f).toInt()

    }


    // 추가) dp 값을 px 값으로 변환해 주는 함수
    private fun dipToPixels(dipValue: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dipValue,
            resources.displayMetrics
        )
    }


}
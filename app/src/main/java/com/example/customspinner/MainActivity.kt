package com.example.customspinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.customspinner.country.CustomSpinnerActivity
import com.example.customspinner.databinding.ActivityMainBinding
import com.example.customspinner.service.ServiceActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val items = arrayOf("데이터0","아이템1","데이터2","아이템3","화이팅4")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        // 버튼 설정 부분
        binding.button1.setOnClickListener {
            val intent = Intent(this, CustomSpinnerActivity::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val intent = Intent(this, ServiceActivity::class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(this, SelectCountryActivity::class.java)
            startActivity(intent)
        }


        // 스피너 설정 부분
        val myAdapter = DefaultSpinnerAdapter(this, items)
        binding.spinner.adapter = myAdapter




        // 기본 스피너
//        val defaultAdapter = ArrayAdapter(this, R.layout.item_default_spinner, items)
        val defaultAdapter = object : ArrayAdapter<String>(this, R.layout.item_default_spinner) {
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
        defaultAdapter.addAll(items.toMutableList())

//힌트로 사용할 문구를 마지막 아이템에 추가해 줍니다.
        defaultAdapter.add("제목입니다.")

//어댑터를 연결해줍니다.
        binding.spinnerDefault.adapter = defaultAdapter

//스피너 초기값을 마지막 아이템으로 설정해 줍니다. (마지막 아이템이 힌트 이기 때문이죠)
        binding.spinnerDefault.setSelection(defaultAdapter.count)

//droplist를 spinner와 간격을 두고 나오게 해줍니다.)
//아이템 크기가 45dp 이므로 45dp 간격을 주었습니다.
//이때 dp 를 px 로 변환해 주는 작업이 필요합니다.
        binding.spinnerDefault.dropDownVerticalOffset = dipToPixels(45f).toInt()


//스피너 선택시 나오는 화면 입니다.
//        binding.spinnerDefault.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
//
//                //아이템이 클릭 되면 맨 위부터 position 0번부터 순서대로 동작하게 됩니다.
//                when (position) {
//                    0 -> {
//
//                    }
//                    1 -> {
//
//                    }
//                    //...
//                    else -> {
//
//                    }
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                Log.e("MyTag", "onNothingSelected")
//            }
//        }






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
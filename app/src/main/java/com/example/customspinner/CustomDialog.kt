package com.example.customspinner

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager

class CustomDialog(context: Context) {

    // 다이얼로그 객체 생성
    private val dialog = Dialog(context)

    fun myDig() {
        dialog.setContentView(R.layout.custom_dialog_view) // 레이아웃 설정
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) // 다이얼로그 설정 배경 투명하게 => 나머지 여백 부분 보이지 않게

        //Dialog 크기 설정
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,)

        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)

        dialog.show()
    }

    // Viewpager2 이용해서 슬라이드 형태 개발

}
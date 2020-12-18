package com.example.customspinner.service

import com.example.customspinner.R
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import android.widget.TextView

//, SpinnerAdapter {
class ServiceCustomSpinnerAdapter(private val ctx: Context, private val items: ArrayList<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }
    override fun getItem(i: Int): Any {
        return items[i]
    }
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }


    override fun getView(i: Int, view: View?, viewgroup: ViewGroup?): View {
//        val txt = TextView(this@ServiceActivity)
        val txt = TextView(ctx)
        txt.gravity = Gravity.CENTER
        txt.setPadding(16, 16, 16, 16)
        txt.textSize = 16f

//        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down_float, 0)
        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_keyboard_arrow_down_50, 0)

        txt.text = items[i]
        txt.setTextColor(Color.parseColor("#000000"))

        return txt
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val txt = TextView(this@ServiceActivity)
        val txt = TextView(ctx)
        txt.setPadding(16, 16, 16, 16)
        txt.textSize = 18f
        txt.gravity = Gravity.CENTER
        txt.text = items[position]
        txt.setTextColor(Color.parseColor("#000000"))
        return txt
    }


}

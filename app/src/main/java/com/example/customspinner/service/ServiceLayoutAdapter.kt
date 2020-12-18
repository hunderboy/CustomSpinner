package com.example.customspinner.service

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.customspinner.R

class ServiceLayoutAdapter(private val ctx: Context, private val items: ArrayList<String>) : BaseAdapter() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)


    override fun getCount(): Int {
        return items.size
    }
    override fun getItem(i: Int): Any {
        return items[i]
    }
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }



    override fun getView(position: Int, convertView: View?, viewgroup: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.layout_everex_spinner_item, viewgroup, false)
//            (view.findViewById(R.id.tvCountry) as TextView).text = "please pickup"
            (view.findViewById(R.id.tvCountry) as TextView).text = items[position]
        }else{
            view = convertView
//            val text = items[position]
//            (convertView.findViewById(R.id.tvCountry) as TextView).text = text
        }

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        // convertView == null 이든 아니든 보여주는 데이터는 동일하게 설정해야 함.
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.layout_everex_spinner_dropdown_item, parent, false)

            val text = items[position]
            (view.findViewById(R.id.textview_spinnerlist) as TextView).text = text
        } else {
            view = convertView

            //데이터세팅
            val text = items[position]
            (convertView.findViewById(R.id.textview_spinnerlist) as TextView).text = text

        }
        return view
    }



}


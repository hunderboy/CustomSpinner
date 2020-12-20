package com.example.customspinner.service

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.customspinner.R



class WeekSpinnerAdapter(private val ctx: Context, private val items: ArrayList<String>) : BaseAdapter() {

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
            view = layoutInflater.inflate(R.layout.layout_week_spinner_item, viewgroup, false)
            (view.findViewById(R.id.week_textview) as TextView).text = items[position]
        }else{
            view = convertView
        }

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.layout_week_dropdown_item, parent, false)

            // convertView == null 이든 아니든 보여주는 데이터는 동일하게 설정해야 함. = 그래야만 dropdown 데이터가 항상 일정함.
            val text = items[position]
            (view.findViewById(R.id.textview_week) as TextView).text = text
        } else {
            view = convertView

            // convertView == null 이든 아니든 보여주는 데이터는 동일하게 설정해야 함. = 그래야만 dropdown 데이터가 항상 일정함.
            val text = items[position]
            (convertView.findViewById(R.id.textview_week) as TextView).text = text

        }
        return view
    }



}

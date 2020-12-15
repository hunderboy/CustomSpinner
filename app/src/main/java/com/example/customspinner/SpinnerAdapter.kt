package com.example.customspinner

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*


class SpinnerAdapter(context: Context, list: Array<String>) : BaseAdapter() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private val mList = list
    private val mContext = context



    override fun getItem(position: Int) = mList[position]
    override fun getCount() = mList.size
    override fun getItemId(position: Int) = position.toLong()
    override fun isEnabled(position: Int) = position != 0
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.spinner_spinner1_normal, parent, false)
        } else {
            view = convertView

            //데이터세팅
            val text = mList[position]
            (convertView.findViewById(R.id.spinnerText) as TextView).text = text

        }
        return view
    }
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.spinner_spinner1_dropdown, parent, false)
        } else {
            view = convertView

            //데이터세팅
            val text = mList[position]
            (convertView.findViewById(R.id.spinnerText) as TextView).text = text

        }
        return view
    }


}
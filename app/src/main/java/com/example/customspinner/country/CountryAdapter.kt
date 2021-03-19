package com.example.customspinner.country

import android.content.Context
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.customspinner.R
import java.util.*

class CountryAdapter(
    context: Context
    private val items: ArrayList<String>
) :
//    ArrayAdapter<OperatedCountry>(context, 0, OperatedCountry.values())
    BaseAdapter()
{

    val layoutInflater: LayoutInflater = LayoutInflater.from(context)



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_country, parent, false)
        } else {
            view = convertView
        }
        getItem(position)?.let { country ->
            setItemForCountry(view, country)
        }
        return view
    }


    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (position == 0) {// 드롭다운의 첫번재 포지션에는 Select option 이 들어간다.
            view = layoutInflater.inflate(R.layout.header_country, parent, false)
            view.setOnClickListener {
                val root = parent.rootView
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
            }
        } else {
            view = layoutInflater.inflate(R.layout.layout_country_dropdown, parent, false)
            getItem(position)?.let { country ->
                setItemForCountry(view, country)
            }
        }
        return view
    }



    override fun getItem(position: Int): OperatedCountry? {
        if (position == 0) {
            return null
        }
        return super.getItem(position - 1)
    }
    override fun getCount() = super.getCount() + 1
    override fun isEnabled(position: Int) = position != 0



    private fun setItemForCountry(view: View, country: OperatedCountry) {
        val tvCountry = view.findViewById<TextView>(R.id.tvCountry)
        val ivCountry = view.findViewById<ImageView>(R.id.ivCountry)

        val countryName = Locale("", country.countryCode).displayCountry
        Log.e("countryName", " = $countryName")

        // countryName 설정
//        val countryName = "United Kingdom"
        tvCountry.text = countryName
        ivCountry.setBackgroundResource(country.icon)
    }



}
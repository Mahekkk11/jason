package com.example.androidpracticals

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class GridAdapter(var context: Context,var arrayList : ArrayList<DataItem>) : BaseAdapter() {
    override fun getCount(): Int {
       return  arrayList.size
    }
    override fun getItem(position: Int): Any {
       return arrayList[position]
    }
    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View = View.inflate(context,R.layout.raw_data,null)
        var icon : ImageView = view.findViewById(R.id.imgLogo)

        var dataItem : DataItem = arrayList[position]
        icon.setImageResource(dataItem.icon)

        return view
    }
}
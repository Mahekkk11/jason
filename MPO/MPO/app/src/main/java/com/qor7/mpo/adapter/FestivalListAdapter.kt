package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.qor7.mpo.R
import com.qor7.mpo.model.FestivalListModel

class FestivalListAdapter(var context: Context, var onClickListener : View.OnClickListener) :
    RecyclerView.Adapter<FestivalListAdapter.MyHolder>() {

    var objList: ArrayList<FestivalListModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_festival_list, parent, false)
        return MyHolder(myView)
    }


    override fun getItemCount(): Int {
        return objList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {


        holder.txtFestival.text = objList[position].festival

        holder.llFestivalView.tag = position
        holder.llFestivalView.setOnClickListener(onClickListener)

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtFestival: AppCompatTextView = itemView.findViewById(R.id.txtFestival)
        var llFestivalView: LinearLayout = itemView.findViewById(R.id.llFestivalView)

    }

    fun addData(mObjList: ArrayList<FestivalListModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
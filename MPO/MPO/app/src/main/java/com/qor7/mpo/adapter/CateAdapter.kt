package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.qor7.mpo.model.CategoryModel

class CateAdapter(var context: Context, var onClickListener : View.OnClickListener) :
    RecyclerView.Adapter<CateAdapter.MyHolder>() {

    var objList: ArrayList<CategoryModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_cate, parent, false)
        return MyHolder(myView)
    }


    override fun getItemCount(): Int {
        return objList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

     /*   holder.imgCat.setActualImageResource(R.drawable.splash)
        if (objList[position].image.isNotEmpty())
            holder.imgCat.setImageURI(objList[position].image)*/

        holder.imgCat.setActualImageResource(objList[position].img)
        holder.txtTitle.text = objList[position].categoryName

        holder.imgCat.tag = position
        holder.imgCat.setOnClickListener(onClickListener)

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgCat: SimpleDraweeView = itemView.findViewById(R.id.imgCat)
        var txtTitle: AppCompatTextView = itemView.findViewById(R.id.txtTitle)

    }

    fun addData(mObjList: ArrayList<CategoryModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.qor7.mpo.model.CategoryItemModel
import kotlin.collections.ArrayList

class FestivalOfferAdapter(var context: Context) :
    RecyclerView.Adapter<FestivalOfferAdapter.MyHolder>() {

    var objList: ArrayList<CategoryItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_festival_offer, parent, false)
        return MyHolder(myView)
    }

    override fun getItemCount(): Int {
        return objList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        //isFrom = 1
      /*  if (isFrom == 1){
            holder.image.layoutParams.height = 200
            holder.image.layoutParams.width = 200
            holder.lblName.setTextAppearance(R.style.Text12RegularBlackStyle)
        }*/


        holder.imgFestivalOffer.setActualImageResource(objList[position].image)

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFestivalOffer: SimpleDraweeView = itemView.findViewById(R.id.imgFestivalOffer)

    }

    fun addData(mObjList: ArrayList<CategoryItemModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
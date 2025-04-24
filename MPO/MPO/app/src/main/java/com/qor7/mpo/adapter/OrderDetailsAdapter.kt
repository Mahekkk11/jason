package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.qor7.mpo.model.CategoryItemModel

class OrderDetailsAdapter(var context: Context, var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<OrderDetailsAdapter.MyHolder>() {

    var objList: ArrayList<CategoryItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_order_details, parent, false)
        return MyHolder(myView)
    }


    override fun getItemCount(): Int {
        return objList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.image.setActualImageResource(objList[position].image)
        holder.lblName.text = objList[position].name
        holder.txtPricePerFlower.text = objList[position].price
        holder.txtTotalPrice.text = objList[position].totalAmount
        holder.txtItemNo.text = objList[position].qty

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: SimpleDraweeView = itemView.findViewById(R.id.image)
        var lblName: AppCompatTextView = itemView.findViewById(R.id.lblName)
        var txtPricePerFlower: AppCompatTextView = itemView.findViewById(R.id.txtPricePerFlower)
        var txtTotalPrice: AppCompatTextView = itemView.findViewById(R.id.txtTotalPrice)
        var txtItemNo: AppCompatTextView = itemView.findViewById(R.id.txtItemNo)


    }

    fun addData(mObjList: ArrayList<CategoryItemModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
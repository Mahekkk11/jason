package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.qor7.mpo.model.OrderItemModel
import kotlin.collections.ArrayList

class OrderItemAdapter(var context: Context, var onClickListener: View.OnClickListener, var isFrom : Int) :
        RecyclerView.Adapter<OrderItemAdapter.MyHolder>() {

    var objList: ArrayList<OrderItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_order_item, parent, false)
        return MyHolder(myView)
    }

    override fun getItemCount(): Int {
        return objList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        //isFrom = 2
        if (isFrom == 1){
            holder.txtDate.text = objList[position].createdAt
            holder.txtStatus.visibility = View.INVISIBLE

        }

        //isFrom = 2
        if (isFrom == 2){
            holder.txtDate.text = "From: " +objList[position].createdAt
            holder.txtStatus.visibility = View.VISIBLE

        }

        holder.image.setActualImageResource(objList[position].image)
       // if(objList[position].image.isNotEmpty())
       //     holder.image.setImageURI(objList[position].image)

        holder.txtName.text = objList[position].name
        holder.txtCode.text = objList[position].code

        holder.txtStatus.text = objList[position].status
        holder.txtPrice.text = "₹"+objList[position].price

        holder.rlOrderView.tag = position
        holder.rlOrderView.setOnClickListener(onClickListener)

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: SimpleDraweeView = itemView.findViewById(R.id.image)
        var txtName: AppCompatTextView = itemView.findViewById(R.id.txtName)
        var txtCode: AppCompatTextView = itemView.findViewById(R.id.txtCode)
        var txtDate: AppCompatTextView = itemView.findViewById(R.id.txtDate)
        var txtStatus: AppCompatTextView = itemView.findViewById(R.id.txtStatus)
        var txtPrice: AppCompatTextView = itemView.findViewById(R.id.txtPrice)
        var rlOrderView: RelativeLayout = itemView.findViewById(R.id.rlOrderView)

    }

    fun addData(mObjList: ArrayList<OrderItemModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.qor7.mpo.model.CategoryItemModel

class OrderAddItemDetailsAdapter(var context: Context, var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<OrderAddItemDetailsAdapter.MyHolder>() {

    var objList: ArrayList<CategoryItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_add_item_order_details, parent, false)
        return MyHolder(myView)
    }


    override fun getItemCount(): Int {
        return objList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        /* holder.imgCat.setActualImageResource(R.drawable.splash)
         if (objList[position].image.isNotEmpty())
             holder.imgCat.setImageURI(objList[position].image)
 */

        holder.image.setActualImageResource(objList[position].image)
        holder.lblName.text = objList[position].name
        holder.txtPricePerFlower.text = objList[position].price
        holder.txtTotalPrice.text = objList[position].totalAmount
        holder.lblQuantity.text = objList[position].qty


        holder.imgDelete.tag = position
        holder.imgDelete.setOnClickListener {
            objList.removeAt(position)
            notifyDataSetChanged()
        }

        holder.txtEdit.tag = position
        holder.txtEdit.setOnClickListener(context as View.OnClickListener)

        holder.txtEdit.tag = position
        holder.txtEdit.setOnClickListener(context as View.OnClickListener)
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: SimpleDraweeView = itemView.findViewById(R.id.image)
        var imgDelete: ImageView = itemView.findViewById(R.id.imgDelete)
        var lblName: AppCompatTextView = itemView.findViewById(R.id.lblName)
        var txtPricePerFlower: AppCompatTextView = itemView.findViewById(R.id.txtPricePerFlower)
        var txtTotalPrice: AppCompatTextView = itemView.findViewById(R.id.txtTotalPrice)
        var txtEdit: AppCompatTextView = itemView.findViewById(R.id.txtEdit)
        var lblQuantity: AppCompatTextView = itemView.findViewById(R.id.lblQuantity)

    }

    fun addData(mObjList: ArrayList<CategoryItemModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
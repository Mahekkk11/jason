package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.qor7.mpo.model.CategoryItemModel
import kotlin.collections.ArrayList

class CategoryItemAdapter(var context: Context, var isFrom : Int) :
    RecyclerView.Adapter<CategoryItemAdapter.MyHolder>() {

    var objList: ArrayList<CategoryItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_category_item, parent, false)
        return MyHolder(myView)
    }

    override fun getItemCount(): Int {
        return objList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        //isFrom = 1
        if (isFrom == 1){
            holder.image.layoutParams.height = 200
            holder.image.layoutParams.width = 200
            holder.lblName.setTextAppearance(R.style.Text12RegularBlackStyle)
        }

        //isFrom = 2
        if (isFrom == 2){
            holder.image.layoutParams.height = 200
            holder.image.layoutParams.width = 200
            holder.lblName.setTextAppearance(R.style.Text12RegularBlackStyle)

            holder.llAddView.visibility = View.INVISIBLE
            holder.lblPrice.visibility = View.INVISIBLE

        }


        if (objList[position].qty.equals("ADD")) {
            holder.btnMinus.visibility = View.GONE

            holder.llAddView.tag = position
            holder.llAddView.setOnClickListener(context as View.OnClickListener)
        } else {
            holder.btnMinus.visibility = View.VISIBLE
        }


      /*  if (objList[position].qty.equals("0")) {
            holder.btnMinus.visibility = View.GONE
        } else {
            holder.btnMinus.visibility = View.VISIBLE
        }*/

        holder.image.setActualImageResource(objList[position].image)
       // if(objList[position].image.isNotEmpty())
       //     holder.image.setImageURI(objList[position].image)

        holder.lblName.text = objList[position].name
        holder.lblDescription.text = objList[position].description
        holder.lblPrice.text = "Rs."+objList[position].price
        holder.lblQuantity.text = if (objList[position].qty.equals("0")) context.resources.getString(R.string.add) else objList[position].qty


         holder.btnMinus.tag = position
         holder.btnMinus.setOnClickListener(context as View.OnClickListener)

         holder.btnPlus.tag = position
         holder.btnPlus.setOnClickListener(context as View.OnClickListener)
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: SimpleDraweeView = itemView.findViewById(R.id.image)
        var lblName: AppCompatTextView = itemView.findViewById(R.id.lblName)
        var lblDescription: AppCompatTextView = itemView.findViewById(R.id.lblDescription)
        var lblPrice: AppCompatTextView = itemView.findViewById(R.id.lblPrice)
        var btnMinus: AppCompatImageView = itemView.findViewById(R.id.btnMinus)
        var btnPlus: AppCompatImageView = itemView.findViewById(R.id.btnPlus)
        var lblQuantity: AppCompatTextView = itemView.findViewById(R.id.lblQuantity)
        var rlMainView: RelativeLayout = itemView.findViewById(R.id.rlMainView)
        var llAddView: LinearLayout = itemView.findViewById(R.id.llAddView)
    }

    fun addData(mObjList: ArrayList<CategoryItemModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
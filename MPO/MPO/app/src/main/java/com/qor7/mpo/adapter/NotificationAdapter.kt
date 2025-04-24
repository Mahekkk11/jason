package com.qor7.mpo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.qor7.mpo.model.CategoryModel
import com.qor7.mpo.model.NotificationModel
import com.qor7.mpo.model.WalletModel

class NotificationAdapter(var context: Context, var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<NotificationAdapter.MyHolder>() {

    var objList: ArrayList<NotificationModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myView =
            LayoutInflater.from(parent.context).inflate(R.layout.raw_notification, parent, false)
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

        holder.txtTitle.text = objList[position].title
        holder.txtSubTitle.text = objList[position].subTitle
        holder.txtTime.text = objList[position].date

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        var txtSubTitle: TextView = itemView.findViewById(R.id.txtSubTitle)
        var txtTime: TextView = itemView.findViewById(R.id.txtTime)

    }

    fun addData(mObjList: ArrayList<NotificationModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        this.notifyDataSetChanged()
    }

}
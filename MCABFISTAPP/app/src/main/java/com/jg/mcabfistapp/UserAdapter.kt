package com.jg.mcabfistapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var obj : Context,var list : ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    // Sub Class Of Main Class
    class ViewHolder(itemview : View):RecyclerView.ViewHolder(itemview)
    {
        var username = itemview.findViewById<TextView>(R.id.txtUserFName)
        var userMsg = itemview.findViewById<TextView>(R.id.txtUserLMsg)
        var userImg = itemview.findViewById<ImageView>(R.id.imgUserProfile)
        var imgDelete = itemview.findViewById<ImageView>(R.id.imgDelete)
        var rlMainView = itemview.findViewById<RelativeLayout>(R.id.rlMainView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var itemView = LayoutInflater.from(parent.context)
           .inflate(R.layout.raw_user_details,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.username.text = list[position].usernaame
        holder.userMsg.text =  list[position].userMsg
        holder.userImg.setImageResource(list[position].img)
        
       holder.imgDelete.tag = position
        holder.imgDelete.setOnClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(obj,"Removed...!",Toast.LENGTH_LONG).show()
        }

        holder.rlMainView.tag = position
        holder.rlMainView.setOnClickListener {
            obj.startActivity(Intent(obj,UserDetailsActivity::class.java)
                .putExtra("IMG",list[position].img)
                .putExtra("FNAME",list[position].usernaame)
                .putExtra("MSG",list[position].userMsg))
        }
    }

}
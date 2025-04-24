package com.jg.firstmca

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var context : Context,var list : ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var username = itemView.findViewById<TextView>(R.id.txtUserName)
        var userMsg = itemView.findViewById<TextView>(R.id.txtUserMsg)
        var imgDelete = itemView.findViewById<ImageView>(R.id.imgDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var viewItem = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.raw_userlist, parent, false)

        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.username.text = list[position].userName
        holder.userMsg.text = list[position].userMsg

        holder.imgDelete.tag = position
        holder.imgDelete.setOnClickListener {
            list.remove(list[position])
            notifyDataSetChanged()
            Toast.makeText(context,"Removed...!",Toast.LENGTH_LONG).show()
        }

    }
}
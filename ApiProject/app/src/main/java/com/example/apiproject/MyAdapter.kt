package com.example.apiproject

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(var con : Context,var userList : List<MyDataItem>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {

        var view = LayoutInflater.from(con).inflate(R.layout.marvel,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = userList[position].name
        holder.subTitle.text = userList[position].realname

       // Log.d("Animaton images>>>>>>>>>>>>>>>>>>",userList[position].imageUrl)

        Glide.with(con).load(userList[position].imageurl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return userList.count()
    }

  inner class ViewHolder(v:View) : RecyclerView.ViewHolder(v){
        var image = v.findViewById<ImageView>(R.id.imgLogo)
        var title = v.findViewById<TextView>(R.id.txtTitle)
        var subTitle = v.findViewById<TextView>(R.id.txtSubTitle)
    }

}
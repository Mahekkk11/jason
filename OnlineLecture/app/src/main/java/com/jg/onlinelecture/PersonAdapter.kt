package com.jg.onlinelecture

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class PersonAdapter(var context : Context,var personList : ArrayList<PersonDataModel>,var onClick : OnClickListener):RecyclerView.Adapter<PersonAdapter.ViewHolder>()  {

    class ViewHolder(nil : View):RecyclerView.ViewHolder(nil)
    {
        var fname = nil.findViewById<TextView>(R.id.txtUserFName)
        var lname = nil.findViewById<TextView>(R.id.txtUserLName)
        var img = nil.findViewById<ImageView>(R.id.imgProfile)
        var mainView = nil.findViewById<CardView>(R.id.mainCardView)
        var deleteItem = nil.findViewById<ImageView>(R.id.viewDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(parent.context).inflate(R.layout.raw_person_data,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
      return personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.fname.setText(personList[position].userFName)
        holder.lname.setText(personList[position].userLName)
        holder.img.setImageResource(personList[position].userProfile)

        holder.mainView.tag = position
        holder.mainView.setOnClickListener {
            context.startActivity(Intent(context,ProductDetailActivity::class.java)
                .putExtra("IMG",personList[position].userProfile)
                .putExtra("FNAME",personList[position].userFName)
                .putExtra("LNAME",personList[position].userLName)
            )
        }

        holder.deleteItem.tag = position
        holder.deleteItem.setOnClickListener(onClick)
 //       holder.deleteItem.setOnClickListener {
//            personList.removeAt(position)
//            notifyDataSetChanged()
//            Toast.makeText(context,"Removed...!",Toast.LENGTH_LONG).show()
//        }
    }

}
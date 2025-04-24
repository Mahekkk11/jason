package com.jg.whatsappclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var productList : ArrayList<ProductData>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)
    {
        var imgProduct = itemview.findViewById<ImageView>(R.id. imgProduct)
        var productName = itemview.findViewById<TextView>(R.id.txtProductName)
        var companyName = itemview.findViewById<TextView>(R.id.txtCompanyName)
        var price = itemview.findViewById<TextView>(R.id.txtProductPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      var view = LayoutInflater.from(parent.context).inflate(R.layout.raw_product,parent,false)
        return ViewHolder(view)
     }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.imgProduct.setImageResource(productList[position].imgProduct)
        holder.productName.text = productList[position].productName
        holder.companyName.text = productList[position].companyName
        holder.price.text = productList[position].price
    }
}
package com.qor7.mpo.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.qor7.mpo.R
import com.qor7.mpo.model.SpinnerModel
import com.qor7.mpo.util.DataUtil


class CustomSpinnerAdapter(var context: Context,var isFrom:Int, val mainPos :Int) : BaseAdapter() {

    var objList: ArrayList<SpinnerModel> = ArrayList()
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private lateinit var locationSpinner: CustomSpinnerAdapter

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val holder: Holder
        if (convertView == null) {
            view = inflater.inflate(
                R.layout.raw_custom_spinner, parent,
                false
            )
            holder = Holder(view)
            view!!.tag = holder
        } else {
            view = convertView
            holder = view.tag as Holder
        }




        holder.txtName.text = objList[position].city
        holder.row.setTag(R.string.app_name,mainPos)

        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return objList.size
    }

    internal class Holder(view: View?) {
        var txtName: TextView = view!!.findViewById(R.id.txtName)
        var row: RelativeLayout =view!!.findViewById(R.id.row)
    }


    fun addData(mObjList: ArrayList<SpinnerModel>) {
        objList = ArrayList()
        objList.addAll(mObjList)
        notifyDataSetChanged()
    }


    fun addData(
        mObjList: ArrayList<SpinnerModel>,
        hint: String
    ) {
        objList = ArrayList()
        val spinnerModel = SpinnerModel()
        spinnerModel.city = hint
        spinnerModel.id = "-1"
        mObjList.add(0, spinnerModel)
        objList.addAll(mObjList)
        notifyDataSetChanged()
    }
}
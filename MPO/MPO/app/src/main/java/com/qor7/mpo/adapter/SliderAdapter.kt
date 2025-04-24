package com.qor7.mpo.adapter

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.facebook.drawee.view.SimpleDraweeView
import com.qor7.mpo.R
import com.rentthething.SliderItemModel

class SliderAdapter(val context: Context, var itemList: List<SliderItemModel>,var onClickListener: View.OnClickListener) :
    PagerAdapter() {

    var mLayoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var pos = 0


    private var dialog: Dialog? = null
    private lateinit var imgClose: AppCompatImageView

    override fun getCount(): Int {
        return itemList.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val holder = ViewHolder()
        val itemView = mLayoutInflater.inflate(R.layout.raw_slider, container, false)
        holder.itemImage = itemView.findViewById(R.id.imgSlider) as SimpleDraweeView

        if (pos > this.itemList.size - 1)
            pos = 0

        holder.sliderItemModel = this.itemList[pos]
        holder.itemImage.setActualImageResource(holder.sliderItemModel.imageDrawable)

        holder.itemImage.tag = position
        holder.itemImage.setOnClickListener(onClickListener)

        (container as ViewPager).addView(itemView)

        pos++
        return itemView
    }

    internal class ViewHolder {
        lateinit var sliderItemModel: SliderItemModel
        lateinit var itemImage: SimpleDraweeView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(
            `object` as
                    RelativeLayout
        )
    }

    override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
        return arg0 === arg1 as View
    }

    override fun destroyItem(arg0: View, arg1: Int, arg2: Any) {
        (arg0 as ViewPager).removeView(arg2 as View)
    }

}

package com.qor7.mpo.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.qor7.mpo.R
import kotlinx.android.synthetic.main.custom_footer.view.*

class CustomFooter @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    LinearLayout(context, attrs, defStyleAttr) {


    companion object {
        var selectedPosition: Int = 0
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_footer, this, true)
        changeBackground(selectedPosition)


        // USER_TYPE 1 > user ,  2 > Recruiter

        /*if (Pref.getIntValue(Pref.PREF_USER_TYPE, 0) == 2) {

            txtNotificationCount.text = Pref.getStringValue(Pref.PREF_NOTIFICATION_COUNT,"0")
            Util.print("txtNotification count Footer >>>>>>>>>>>"+Pref.getStringValue(Pref.PREF_NOTIFICATION_COUNT,"0"))

            imgProduct.setImageResource(R.drawable.ic_bag_unselected)
            txtSearch.text = resources.getString(R.string.jobs)

            //imgBag.setImageResource(R.drawable.img_notification_unselected)
            imgBag.visibility = View.GONE

            rlNotificationView.visibility = View.VISIBLE
            txtApplied.text = resources.getString(R.string.notification)

        } else {
            imgProduct.setImageResource(R.drawable.ic_search_unselected)
            txtSearch.text = resources.getString(R.string.find)

            imgBag.setImageResource(R.drawable.ic_bag_unselected)
            txtApplied.text = resources.getString(R.string.applied)
        }*/
    }

    fun changeBackground(position: Int) {
        selectedPosition = position
        imgHome.setImageResource(if (position == 0) R.drawable.ic_select_home else R.drawable.ic_unselect_home)
        txtHome.setTextColor(
            if (position == 0) ContextCompat.getColor(
                context,
                R.color.colorDarkBlue
            ) else ContextCompat.getColor(context, R.color.colorLightGray)
        )



        imgWallet.setImageResource(if (position == 1) R.drawable.ic_select_wallet else R.drawable.ic_unselect_wallet)
        txtWallet.setTextColor(if (position == 1) ContextCompat.getColor(context, R.color.colorDarkBlue) else ContextCompat.getColor(context, R.color.colorLightGray))


        imgHelp.setImageResource(if (position == 2) R.drawable.ic_select_help else R.drawable.ic_unselect_help)
        txtHelp.setTextColor(
            if (position == 2) ContextCompat.getColor(
                context,
                R.color.colorDarkBlue
            ) else ContextCompat.getColor(context, R.color.colorLightGray)
        )


        imgMore.setImageResource(if (position == 3) R.drawable.ic_select_more else R.drawable.ic_unselect_more)
        txtMore.setTextColor(
            if (position == 3) ContextCompat.getColor(
                context,
                R.color.colorDarkBlue
            ) else ContextCompat.getColor(context, R.color.colorLightGray)
        )
    }

  /*  fun setChatCount(){
        txtNotificationCount.visibility = if (Pref.getStringValue(Pref.PREF_NOTIFICATION_COUNT, "0").equals("0") || Pref.getStringValue(Pref.PREF_NOTIFICATION_COUNT, "0").equals("")) View.GONE else View.VISIBLE
        txtNotificationCount.text = Pref.getStringValue(Pref.PREF_NOTIFICATION_COUNT, "0").toString()
    }
*/
}

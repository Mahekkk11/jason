package com.qor7.mpo.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.qor7.mpo.R
import kotlinx.android.synthetic.main.cust_header.view.*

class CustomHeader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.cust_header, this, true)
        imgLeft.setOnClickListener {
//            Util.hideKeyBoard(context,it)
            if (context is AppCompatActivity)
                context.finish()
        }
    }

}
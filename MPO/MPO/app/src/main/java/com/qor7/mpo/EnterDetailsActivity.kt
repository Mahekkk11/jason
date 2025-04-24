package com.qor7.mpo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.qor7.mpo.adapter.CustomSpinnerAdapter
import com.qor7.mpo.util.DataUtil
import kotlinx.android.synthetic.main.activity_enter_details.*

class EnterDetailsActivity : BaseActivity(), View.OnClickListener {

    private lateinit var locationSpinner: CustomSpinnerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_details)

        initialization()
    }

    private fun initialization() {

        bntSubmit.setOnClickListener(this)


        /*SPINNER*/
        locationSpinner = CustomSpinnerAdapter(this, 0, 0)
        DataUtil.locationCity(this, locationSpinner)
        spLocation.adapter = locationSpinner
        spLocation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                view.setBackgroundColor(Color.TRANSPARENT)

                view.findViewById<AppCompatTextView>(R.id.txtName).setTextColor(
                    if (pos == 0) ContextCompat.getColor(
                        this@EnterDetailsActivity,
                        R.color.colorDarkGray
                    ) else ContextCompat.getColor(this@EnterDetailsActivity, R.color.colorBlack)
                )
                view.findViewById<AppCompatTextView>(R.id.txtName).textSize = 14f
            }

            override fun onNothingSelected(parent: AdapterView<out Adapter>?) {
            }
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bntSubmit->
            {
                startActivity(Intent(this@EnterDetailsActivity,MainActivity::class.java))
                finishAffinity()
            }
        }
    }


}
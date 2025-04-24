package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_delivery_details.*
import kotlinx.android.synthetic.main.cust_header.view.*

class DeliveryDetailsActivity : BaseActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_details)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.enter_Delivery_details)

        btnContinue.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnContinue -> {
                startActivity(Intent(this@DeliveryDetailsActivity,PaymentActivity::class.java))
            }
        }
    }
}
package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_delivery_details.*
import kotlinx.android.synthetic.main.activity_delivery_details.customHeader
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.cust_header.view.*

class PaymentActivity : BaseActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.payments)

        llEndView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.llEndView -> {
                startActivity(Intent(this@PaymentActivity,ExploreProductActivity::class.java))
            }
        }
    }
}
package com.qor7.mpo

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_enter_details.*
import kotlinx.android.synthetic.main.cust_header.view.*

class AlertActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.alerts)

    }

    override fun onClick(view: View) {
        when (view.id) {
        }
    }
}
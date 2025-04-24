package com.qor7.mpo

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.cust_header.view.*

class MyAccountActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.my_account)
        btnSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSave -> {
                finish()
            }
        }
    }


}
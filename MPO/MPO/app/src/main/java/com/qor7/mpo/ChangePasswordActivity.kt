package com.qor7.mpo

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.cust_header.view.*

class ChangePasswordActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.change_password)
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSubmit -> {
                finish()
            }
        }
    }
}
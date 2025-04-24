package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_enter_details.*
import kotlinx.android.synthetic.main.activity_enter_details.customHeader
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.activity_services.*
import kotlinx.android.synthetic.main.cust_header.view.*

class ServicesActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.services)

        btnTerms.setOnClickListener(this)
        btnFaq.setOnClickListener(this)
        btnInvite.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnFaq -> {
                startActivity(
                    Intent(this@ServicesActivity, TermsAndConditionActivity::class.java).putExtra(
                        "ISFROM",
                        1
                    )
                )
            }
            R.id.btnTerms -> {
                startActivity(Intent(this@ServicesActivity, TermsAndConditionActivity::class.java))
            }
            R.id.btnInvite -> {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Hey check out my ComingSoon Application for Flower "
                )
                sendIntent.type = "text/plain"
                startActivity(sendIntent)
            }
          /*  R.id.btnRate -> {
                startActivity(Intent(this@ServicesActivity, TermsAndConditionActivity::class.java))
            }
            R.id.btnContact -> {
                startActivity(Intent(this@ServicesActivity, TermsAndConditionActivity::class.java))
            }*/
        }
    }
}
package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.qor7.mpo.util.IS_FROM
import kotlinx.android.synthetic.main.activity_enter_details.*
import kotlinx.android.synthetic.main.activity_services.*
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        initialization()
    }

    private fun initialization() {

        btnCreateAccount.setOnClickListener(this)
        bntSignIn.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnCreateAccount -> {
                startActivity(
                    Intent(this@WelcomeActivity, VerifyNumberActivity::class.java).putExtra(
                        IS_FROM, 1
                    )
                )
            }
            R.id.bntSignIn -> {
                startActivity(Intent(this@WelcomeActivity, VerifyNumberActivity::class.java).putExtra(IS_FROM,2))
            }
        }
    }


}
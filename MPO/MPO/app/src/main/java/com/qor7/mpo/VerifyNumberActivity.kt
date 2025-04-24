package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.qor7.mpo.util.IS_FROM
import kotlinx.android.synthetic.main.activity_enter_verify_your_mobile.*
import kotlinx.android.synthetic.main.activity_otp.*
import kotlinx.android.synthetic.main.activity_otp.btnSubmit

class VerifyNumberActivity : BaseActivity(), View.OnClickListener {

    private var isFrom : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_verify_your_mobile)

        initialization()
    }

    private fun initialization() {

        isFrom = intent.getIntExtra(IS_FROM,0)

        txtTitle.text = if(isFrom == 1) resources.getString(R.string.verify_your_mobile) else resources.getString(R.string.sign_in_to_your_account)
        btnSubmit.text = if(isFrom == 1) resources.getString(R.string.submit) else resources.getString(R.string.send_otp)

        btnSubmit.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnSubmit -> {
                if(isFrom == 1){
                    startActivity(Intent(this@VerifyNumberActivity, EnterDetailsActivity::class.java))}
                else{
                    startActivity(Intent(this@VerifyNumberActivity, OTPActivity::class.java))
                }
            }
        }
    }

    /* private fun countDownTimerCall() {
         object : CountDownTimer(600000, 100) {
             override fun onTick(millisUntilFinished: Long) {
                 btnReSendCode.setOnClickListener(null)
                 var second = ""
                 val min: Long = millisUntilFinished / 1000 / 60
                 val sec: Long = millisUntilFinished / 1000 % 60

                 lblExpireTime.text = String.format(
                     resources.getString(R.string.code_will_expire_in), " " + (when {
                         sec < 10 -> {
                             second = "0$sec"
                             "$min:$second"
                         }
                         else -> {
                             "$min:$sec"
                         }
                     }).toString()
                 )
             }

             override fun onFinish() {
                 btnReSendCode.setOnClickListener(this@OTPActivity)
                 btnReSendCode.text = String.format(resources.getString(R.string.resend_code))
             }
         }.start()
     }*/

}
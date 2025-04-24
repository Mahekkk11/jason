package com.qor7.mpo

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_terms_and_condition.*
import kotlinx.android.synthetic.main.cust_header.view.*

class TermsAndConditionActivity : BaseActivity() {

    private var isFrom : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_condition)

        isFrom = intent.getIntExtra("ISFROM",0)

        Log.d("TAG","PRINT >>>>>>>>>>>>>>>>>>>>>>>>>>"+ intent.getIntExtra("ISFROM",0))
        Log.d("TAG","PRINT 1>>>>>>>>>>>>>>>>>>>>>>>>>>"+ isFrom)

        initialization()

    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = if(isFrom == 1) resources.getString(R.string.faq) else resources.getString(R.string.terms_condition)

        txtTermsAndConditionContent.text =
            resources.getString(R.string.terms_and_condition_dummy_text)
    }
}
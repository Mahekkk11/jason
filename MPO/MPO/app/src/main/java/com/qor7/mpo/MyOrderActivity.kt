package com.qor7.mpo

import android.os.Bundle
import com.qor7.mpo.adapter.ViewPagerAdapter
import com.qor7.mpo.fragment.NormalOrdersFragment
import com.qor7.mpo.fragment.SubscriptionOrdersFragment
import kotlinx.android.synthetic.main.activity_my_order.*
import kotlinx.android.synthetic.main.cust_header.view.*

class MyOrderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = getString(R.string.my_orders)


        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(NormalOrdersFragment(), resources.getString(R.string.normal_orders))
        adapter.addFragment(SubscriptionOrdersFragment(), resources.getString(R.string.subscription_order))
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }


}
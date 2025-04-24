package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.qor7.mpo.adapter.*
import com.qor7.mpo.fragment.HelpFragment
import com.qor7.mpo.fragment.HomeFragment
import com.qor7.mpo.fragment.MoreFragment
import com.qor7.mpo.fragment.WalletFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cust_header.view.*
import kotlinx.android.synthetic.main.custom_footer.*

class MainActivity : BaseActivity(), View.OnClickListener {

    lateinit var currentFragment: Fragment
    lateinit var ft: androidx.fragment.app.FragmentTransaction

    private var isFrom: Int = 0

    companion object {
        var selectedPosition: Int = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.colorWhite)

        initialization()

    }

    private fun initialization() {

        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frameLayout, HomeFragment())
        ft.commit()

        imgHome.setImageResource(R.drawable.ic_select_home)

        changeFragment(0)

        customDrawer.setDrawer(drawer)

        btnHome.setOnClickListener(this)
        btnWallet.setOnClickListener(this)
        btnHelp.setOnClickListener(this)
        btnMore.setOnClickListener(this)
        customHeader.imgLeft.setOnClickListener(this)
        customHeader.imgRight1.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnHome ->    // Footer Home
            {
                if (selectedPosition != 0) {
                    changeFragment(0)
                }
            }
            R.id.btnWallet -> {       // Footer Wallet
                if (selectedPosition != 1) {
                    changeFragment(1)
                }
            }
            R.id.btnHelp -> {    // Footer Help
                if (selectedPosition != 2) {
                    changeFragment(2)
                }
            }
            R.id.btnMore -> {    // Footer More
                if (selectedPosition != 3) {
                    changeFragment(3)
                }
            }

            R.id.imgLeft -> {
                drawer.openDrawer(GravityCompat.START)
            }

            R.id.imgRight1 -> {
                if (selectedPosition == 0) {
                    startActivity(Intent(this@MainActivity, MyAccountActivity::class.java))
                }
            }
        }
    }

    fun changeFragment(pos: Int) {
        selectedPosition = pos
        customFooter.changeBackground(selectedPosition)
       // customFooter.txtNotificationCount.visibility = if (Pref.getIntValue(Pref.PREF_NOTIFICATION_COUNT,0) != 0) View.VISIBLE else View.GONE

        @Suppress("IMPLICIT_CAST_TO_ANY")
        currentFragment = if (pos == 0) HomeFragment() else if (pos == 1) WalletFragment() else if (pos == 2) HelpFragment() else MoreFragment() as Fragment

        ft = supportFragmentManager.beginTransaction()

        ft.replace(R.id.frameLayout, currentFragment)
        ft.commit()

        when (pos) {
            0 -> {
                customHeader.imgLeft.visibility = View.VISIBLE
                customHeader.imgLeft.setImageResource(R.drawable.ic_humburger)
                customHeader.txtHeaderTitle.text = resources.getText(R.string.home)
                customHeader.imgRight1.visibility = View.VISIBLE
                customHeader.imgRight1.setImageResource(R.drawable.ic_user)
            }
            1 -> {
                customHeader.imgLeft.visibility = View.VISIBLE
                customHeader.imgLeft.setImageResource(R.drawable.ic_humburger)
                        customHeader.txtHeaderTitle.text = resources.getText(R.string.my_wallet)
                customHeader.imgRight1.visibility = View.INVISIBLE
            }
            2 -> {
                customHeader.imgLeft.visibility = View.VISIBLE
                customHeader.imgLeft.setImageResource(R.drawable.ic_humburger)
                customHeader.txtHeaderTitle.text = resources.getText(R.string.chat_bot)
                customHeader.imgRight1.visibility = View.INVISIBLE
            }
            3 -> {
                customHeader.imgLeft.visibility = View.VISIBLE
                customHeader.imgLeft.setImageResource(R.drawable.ic_humburger)
                customHeader.txtHeaderTitle.text = resources.getText(R.string.more)
                customHeader.imgRight1.visibility = View.INVISIBLE
            }

        }

       /* when (pos) {
            0 -> {
                customHeader.txtHeaderTitle.text = resources.getText(R.string.home)
                customHeader.imgRight.visibility = View.VISIBLE
            }
            1 -> {
                customHeader.txtHeaderTitle.text = resources.getText(R.string.friend_list)
                customHeader.imgRight.visibility = View.VISIBLE
            }
            2 -> {
                // customHeader.txtHeaderTitle.text = resources.getText(R.string.friend_list)
            }
            3 -> {
                customHeader.txtHeaderTitle.text = resources.getText(R.string.notification)
                customHeader.imgRight.visibility = View.VISIBLE
            }
            4 -> {
                customHeader.txtHeaderTitle.text = resources.getText(R.string.profile)
                customHeader.imgRight.visibility = View.VISIBLE
            }
        }*/

    }

}
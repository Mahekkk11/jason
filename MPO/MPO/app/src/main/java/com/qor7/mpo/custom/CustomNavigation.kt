package com.qor7.mpo.custom

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.qor7.mpo.*
import kotlinx.android.synthetic.main.custom_drawerview.view.*

class CustomNavigation @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes), View.OnClickListener {

    private lateinit var mDrawer: DrawerLayout
    private var mContext: Context = context

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_drawerview, this, true)
        orientation = VERTICAL


        txtUserName.text = String.format(resources.getString(R.string.hey), "User Name")

        btnHome.setOnClickListener(this)
        btnMyAccount.setOnClickListener(this)
        btnMyOrders.setOnClickListener(this)
        btnMyWallet.setOnClickListener(this)
        btnAlerts.setOnClickListener(this)
        btnNotifications.setOnClickListener(this)
        btnServices.setOnClickListener(this)
        btnChangePwd.setOnClickListener(this)
        btnLogOut.setOnClickListener(this)

    }

    fun setDrawer(drawer: DrawerLayout) {
        this.mDrawer = drawer
    }

    override fun onClick(view: View) {
        //mDrawer.closeDrawer(GravityCompat.START)
        when (view.id) {
            R.id.btnHome -> {
                if (mContext is MainActivity) {
                    mDrawer.closeDrawer(Gravity.LEFT)
                } else {
                    mDrawer.closeDrawer(Gravity.LEFT)
                    mContext.startActivity(Intent(mContext, MainActivity::class.java))
                }
            }
            R.id.btnMyOrders -> {
                mDrawer.closeDrawer(Gravity.LEFT)
                mContext.startActivity(Intent(mContext, MyOrderActivity::class.java))
            }
            R.id.btnMyAccount -> {
                mDrawer.closeDrawer(Gravity.LEFT)
                mContext.startActivity(Intent(mContext, MyAccountActivity::class.java))
            }
            R.id.btnServices -> {
                mDrawer.closeDrawer(Gravity.LEFT)
                mContext.startActivity(Intent(mContext, ServicesActivity::class.java))
            }
            R.id.btnAlerts -> {
                mDrawer.closeDrawer(Gravity.LEFT)
                mContext.startActivity(Intent(mContext, AlertActivity::class.java))
            }
            R.id.btnMyWallet -> {
                mDrawer.closeDrawer(Gravity.LEFT)
                mContext.startActivity(Intent(mContext, WalletActivity::class.java))
            }
            R.id.btnNotifications -> {
                mDrawer.closeDrawer(Gravity.LEFT)
                mContext.startActivity(Intent(mContext, NotificationActivity::class.java))
            }
            R.id.btnChangePwd -> {
                mDrawer.closeDrawer(Gravity.LEFT)
                mContext.startActivity(Intent(mContext, ChangePasswordActivity::class.java))
            }
            R.id.btnLogOut -> {
                mContext.startActivity(Intent(mContext, WelcomeActivity::class.java))
                ActivityCompat.finishAffinity(mContext as AppCompatActivity)
            }
        }
    }
}
package com.qor7.mpo

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qor7.mpo.adapter.WalletAdapter
import com.qor7.mpo.model.WalletModel
import kotlinx.android.synthetic.main.activity_enter_verify_your_mobile.txtTitle
import kotlinx.android.synthetic.main.activity_wallet.*
import kotlinx.android.synthetic.main.cust_header.view.*

class WalletActivity : BaseActivity(), View.OnClickListener {

    private lateinit var walletAdapter: WalletAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        initialization()

    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getString(R.string.my_wallet)

        walletAdapter = WalletAdapter(this, this)
        listWallet.layoutManager = LinearLayoutManager(this)
        listWallet.adapter = walletAdapter
        data()

    }

    override fun onClick(view: View) {
        when (view.id) {
        }
    }

    private fun data() {
        var walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletModel = WalletModel()
        walletModel.title = "Added to Wallet"
        walletModel.price = resources.getString(R.string.indian_rupee) + "100"
        walletModel.date = "1 Feb'19 . #123456"
        walletAdapter.objList.add(walletModel)

        walletAdapter.addData(walletAdapter.objList)
    }

}
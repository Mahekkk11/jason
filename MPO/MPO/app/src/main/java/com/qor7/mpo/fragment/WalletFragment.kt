package com.qor7.mpo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.qor7.mpo.R
import com.qor7.mpo.adapter.WalletAdapter
import com.qor7.mpo.model.WalletModel
import kotlinx.android.synthetic.main.fragment_wallet.view.*

class WalletFragment : Fragment(), View.OnClickListener {

    lateinit var rootView: View
    private lateinit var walletAdapter: WalletAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_wallet, container, false)

        initialization()

        return rootView
    }

    private fun initialization() {

       // customHeader.txtHeaderTitle.text = resources.getString(R.string.my_wallet)

        walletAdapter = WalletAdapter(requireActivity(), this)
        rootView.listWallet.layoutManager = LinearLayoutManager(requireActivity())
        rootView.listWallet.adapter = walletAdapter
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
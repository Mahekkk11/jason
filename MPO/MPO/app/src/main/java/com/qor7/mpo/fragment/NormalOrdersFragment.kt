package com.qor7.mpo.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qor7.mpo.OrderDetailsActivity
import com.qor7.mpo.R
import com.qor7.mpo.adapter.OrderItemAdapter
import com.qor7.mpo.model.OrderItemModel
import kotlinx.android.synthetic.main.fragment_normal_orders.view.*


class NormalOrdersFragment : Fragment(), View.OnClickListener {

    lateinit var rootView: View
    lateinit var orderItemAdapter: OrderItemAdapter

    private var lastPos: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_normal_orders, container, false)

        orderItemAdapter = OrderItemAdapter(requireActivity(), this,1)
        rootView.rlOrderList.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rootView.rlOrderList.adapter = orderItemAdapter
        orderList()

        return rootView
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.rlOrderView -> {
                lastPos = Integer.parseInt(view.tag.toString())
                startActivity(Intent(requireActivity(),OrderDetailsActivity::class.java))
            }
        }
    }


    private fun orderList() {
        orderItemAdapter.objList = ArrayList()

        var orderItemModel = OrderItemModel()
        orderItemModel.image = R.drawable.ic_flower
        orderItemModel.name = resources.getString(R.string.diwali_pack_1)
        orderItemModel.code = resources.getString(R.string.dummy_code)
        orderItemModel.createdAt = resources.getString(R.string.dummy_date)
        orderItemModel.price = resources.getString(R.string.dummy_price)
        orderItemAdapter.objList.add(orderItemModel)

        orderItemModel = OrderItemModel()
        orderItemModel.image = R.drawable.ic_flower
        orderItemModel.name = resources.getString(R.string.diwali_pack_1)
        orderItemModel.code = resources.getString(R.string.dummy_code)
        orderItemModel.createdAt = resources.getString(R.string.dummy_date)
        orderItemModel.price = resources.getString(R.string.dummy_price)
        orderItemAdapter.objList.add(orderItemModel)

        orderItemModel = OrderItemModel()
        orderItemModel.image = R.drawable.ic_flower
        orderItemModel.name = resources.getString(R.string.diwali_pack_1)
        orderItemModel.code = resources.getString(R.string.dummy_code)
        orderItemModel.createdAt = resources.getString(R.string.dummy_date)
        orderItemModel.price = resources.getString(R.string.dummy_price)
        orderItemAdapter.objList.add(orderItemModel)

        orderItemAdapter.addData(orderItemAdapter.objList)

    }

}
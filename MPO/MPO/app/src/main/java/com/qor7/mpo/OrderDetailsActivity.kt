package com.qor7.mpo

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qor7.mpo.adapter.OrderAddItemDetailsAdapter
import com.qor7.mpo.adapter.OrderDetailsAdapter
import com.qor7.mpo.model.CategoryItemModel
import kotlinx.android.synthetic.main.activity_enter_details.customHeader
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.cust_header.view.*

class OrderDetailsActivity : BaseActivity(), View.OnClickListener {

    private lateinit var orderDetailsAdapter: OrderDetailsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.order_details)

        orderDetailsAdapter = OrderDetailsAdapter(this, this)
        listOrderDetails.layoutManager = LinearLayoutManager(this)
        listOrderDetails.adapter = orderDetailsAdapter
        dataList()

    }

    override fun onClick(view: View) {
        when (view.id) {
        }
    }


    private fun dataList() {

        var categoryItemModel = CategoryItemModel()
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = resources.getString(R.string.diwali_pack_1)
        categoryItemModel.price = resources.getString(R.string.dummy_price_item)
        categoryItemModel.totalAmount = "₹150"
        categoryItemModel.qty = "3"
        orderDetailsAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = resources.getString(R.string.diwali_pack_1)
        categoryItemModel.price = resources.getString(R.string.dummy_price_item)
        categoryItemModel.totalAmount = "₹150"
        categoryItemModel.qty = "2"
        orderDetailsAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = resources.getString(R.string.diwali_pack_1)
        categoryItemModel.price = resources.getString(R.string.dummy_price_item)
        categoryItemModel.totalAmount = "₹150"
        categoryItemModel.qty = "1"
        orderDetailsAdapter.objList.add(categoryItemModel)


        orderDetailsAdapter.addData(orderDetailsAdapter.objList)

    }
}
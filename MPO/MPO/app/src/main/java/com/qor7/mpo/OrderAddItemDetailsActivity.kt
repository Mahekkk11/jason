
package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qor7.mpo.adapter.OrderAddItemDetailsAdapter
import com.qor7.mpo.model.CategoryItemModel
import kotlinx.android.synthetic.main.activity_enter_details.customHeader
import kotlinx.android.synthetic.main.activity_order_add_item_details.*
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.activity_order_details.listOrderDetails
import kotlinx.android.synthetic.main.cust_header.view.*

class OrderAddItemDetailsActivity : BaseActivity(),View.OnClickListener {

    private lateinit var orderAddItemDetailsAdapter: OrderAddItemDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_add_item_details)


        initialization()

    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getText(R.string.order_details)

        orderAddItemDetailsAdapter = OrderAddItemDetailsAdapter(this, this)
        listOrderDetails.layoutManager = LinearLayoutManager(this)
        listOrderDetails.adapter = orderAddItemDetailsAdapter
        dataList()

        llEndView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.llEndView -> {
                startActivity(Intent(this@OrderAddItemDetailsActivity, DeliveryDetailsActivity::class.java))
            }
        }
    }

    private fun dataList() {

        var categoryItemModel = CategoryItemModel()
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = "Agiyaras Pack"
        categoryItemModel.price = "₹50 Each"
        categoryItemModel.totalAmount = "₹150"
        categoryItemModel.qty = "3"
        orderAddItemDetailsAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = "Agiyaras Pack"
        categoryItemModel.price = "₹50 Each"
        categoryItemModel.totalAmount = "₹150"
        categoryItemModel.qty = "2"
        orderAddItemDetailsAdapter.objList.add(categoryItemModel)
/*

        categoryItemModel = CategoryItemModel()
        categoryItemModel.image = R.drawable.slider_one
        categoryItemModel.name = "Agiyaras Pack"
        categoryItemModel.price = "₹50 Each"
        categoryItemModel.totalAmount = "₹150"
        categoryItemModel.qty = "1"
        orderDetailsAdapter.objList.add(categoryItemModel)
*/


        orderAddItemDetailsAdapter.addData(orderAddItemDetailsAdapter.objList)

    }

}
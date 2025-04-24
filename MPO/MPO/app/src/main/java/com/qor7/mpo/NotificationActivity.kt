package com.qor7.mpo

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.qor7.mpo.adapter.NotificationAdapter
import com.qor7.mpo.model.NotificationModel
import kotlinx.android.synthetic.main.activity_notificationt.*
import kotlinx.android.synthetic.main.cust_header.view.*

class NotificationActivity : BaseActivity(), View.OnClickListener {

    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificationt)

        initialization()

    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getString(R.string.notifications)

        notificationAdapter = NotificationAdapter(this, this)
        listNotification.layoutManager = LinearLayoutManager(this)
        listNotification.adapter = notificationAdapter
        notificationList()

    }

    override fun onClick(view: View) {
        when (view.id) {
        }
    }

    private fun notificationList() {
        var notificationModel = NotificationModel()
        notificationModel.title = "Lorem Ipsum"
        notificationModel.subTitle =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        notificationModel.date = "10h ago"
        notificationAdapter.objList.add(notificationModel)

        notificationModel = NotificationModel()
        notificationModel.title = "Lorem Ipsum"
        notificationModel.subTitle =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        notificationModel.date = "10h ago"
        notificationAdapter.objList.add(notificationModel)

        notificationModel = NotificationModel()
        notificationModel.title = "Lorem Ipsum"
        notificationModel.subTitle =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        notificationModel.date = "10h ago"
        notificationAdapter.objList.add(notificationModel)

        notificationModel = NotificationModel()
        notificationModel.title = "Lorem Ipsum"
        notificationModel.subTitle =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        notificationModel.date = "10h ago"
        notificationAdapter.objList.add(notificationModel)

        notificationModel = NotificationModel()
        notificationModel.title = "Lorem Ipsum"
        notificationModel.subTitle =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        notificationModel.date = "10h ago"
        notificationAdapter.objList.add(notificationModel)

        notificationModel = NotificationModel()
        notificationModel.title = "Lorem Ipsum"
        notificationModel.subTitle =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        notificationModel.date = "10h ago"
        notificationAdapter.objList.add(notificationModel)

        notificationAdapter.addData(notificationAdapter.objList)
    }

}
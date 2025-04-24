package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.qor7.mpo.adapter.SliderAdapter
import com.qor7.mpo.model.CategoryItemModel
import com.qor7.mpo.adapter.CategoryItemAdapter
import com.qor7.mpo.util.IS_FROM
import com.rentthething.SliderItemModel
import kotlinx.android.synthetic.main.activity_category_process.*
import kotlinx.android.synthetic.main.cust_header.view.*

class CategoryProcessActivity : BaseActivity(), View.OnClickListener {

    lateinit var categoryItemAdapter: CategoryItemAdapter

    /*slider*/
    lateinit var viewPager: ViewPager
    lateinit var lytPageIndicator: LinearLayout
    lateinit var sliderItems: MutableList<SliderItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_process)

        customHeader.txtHeaderTitle.text = resources.getString(R.string.customise_pack)
        customHeader.imgRight1.setImageResource(R.drawable.ic_bag)

        categoryItemAdapter = CategoryItemAdapter(this@CategoryProcessActivity, 1)
        rvCategoryItem.layoutManager =
            LinearLayoutManager(this@CategoryProcessActivity, RecyclerView.VERTICAL, false)
        rvCategoryItem.adapter = categoryItemAdapter


        /*Slider*/
        try {

            viewPager = findViewById(R.id.viewPager)
            lytPageIndicator = findViewById(R.id.pageIndicator)

            sliderItems = ArrayList()
            sliderItems.add(SliderItemModel(1, R.drawable.slider_one, "Get 20% Off"))
            sliderItems.add(SliderItemModel(2, R.drawable.slider_two, "Get 20% Off"))
            sliderItems.add(SliderItemModel(3, R.drawable.slider_one, "Get 20% Off"))
            sliderItems.add(SliderItemModel(3, R.drawable.slider_two, "Get 20% Off"))

            val adapter = SliderAdapter(this, sliderItems,this)
            viewPager.adapter = adapter
            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    activeDeActivePageIndicator()
                }

                override fun onPageScrollStateChanged(state: Int) {
                }
            })
            viewPager.currentItem = 0

            setPagerIndicator()

        } catch (ex: Exception) {
            Log.e("", ex.message.toString())
        }

        categoryItemList()

        llEndView.setOnClickListener(this)
        
    }

    private fun categoryItemList() {
        categoryItemAdapter.objList = ArrayList()

        var categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "0"
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = "Flowers"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemModel.price = "49"
        categoryItemModel.qty = "3"
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "1"
        categoryItemModel.image = R.drawable.ic_pooja_thali
        categoryItemModel.name = "Kanku, Chandan"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemModel.price = resources.getString(R.string.rs_49)
        categoryItemModel.qty =
            "1"
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "2"
        categoryItemModel.image = R.drawable.ic_flower_offer
        categoryItemModel.name = "Dhupbatti"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemModel.price = resources.getString(R.string.rs_49)
        categoryItemModel.qty =
            "2"
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "3"
        categoryItemModel.image = R.drawable.ic_flower_dees
        categoryItemModel.name = "Pooja chattai"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemModel.price = resources.getString(R.string.rs_49)
        categoryItemModel.qty =
            "1"
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "4"
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = "Flowers"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemModel.price = resources.getString(R.string.rs_49)
        categoryItemModel.qty =
            "2"
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemAdapter.addData(categoryItemAdapter.objList)
    }

    fun activeDeActivePageIndicator() {
        for (i in 0 until lytPageIndicator.childCount) {
            (lytPageIndicator.getChildAt(i) as ImageView).setImageResource(if (viewPager.currentItem == i) R.drawable.ic_blue_dot else R.drawable.ic_gray_dot)
        }

    }

    private fun setPagerIndicator() {
        lytPageIndicator.removeAllViews()
        for (i in sliderItems.indices) {
            val imgView = ImageView(this)
            val param: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                resources.getDimensionPixelSize(R.dimen._7sdp),
                resources.getDimensionPixelSize(R.dimen._7sdp)
            )
//            var  param: LinearLayout.LayoutParams = LinearLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen._5sdp),resources.getDimensionPixelSize(R.dimen._5sdp))
            param.setMargins(
                resources.getDimensionPixelSize(R.dimen._1sdp),
                resources.getDimensionPixelSize(R.dimen._1sdp),
                resources.getDimensionPixelSize(R.dimen._1sdp),
                resources.getDimensionPixelSize(R.dimen._1sdp)
            )
            imgView.id = i
            imgView.layoutParams = param
            imgView.setImageResource(if (viewPager.currentItem == i) R.drawable.ic_blue_dot else R.drawable.ic_gray_dot)

            lytPageIndicator.addView(imgView)
        }

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.llEndView -> {
                startActivity(Intent(this@CategoryProcessActivity,OrderAddItemDetailsActivity::class.java))
            }
        }
    }
}
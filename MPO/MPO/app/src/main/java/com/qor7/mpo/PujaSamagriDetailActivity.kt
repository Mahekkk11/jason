package com.qor7.mpo

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.qor7.mpo.adapter.CategoryItemAdapter
import com.qor7.mpo.adapter.FestivalOfferAdapter
import com.qor7.mpo.adapter.SliderAdapter
import com.qor7.mpo.model.CategoryItemModel
import com.rentthething.SliderItemModel
import kotlinx.android.synthetic.main.activity_puja_samgri_detail.*
import kotlinx.android.synthetic.main.activity_puja_samgri_detail.customHeader
import kotlinx.android.synthetic.main.activity_puja_samgri_detail.rvCategoryItem
import kotlinx.android.synthetic.main.cust_header.view.*

class PujaSamagriDetailActivity : BaseActivity(),View.OnClickListener {

    lateinit var categoryItemAdapter: CategoryItemAdapter
    lateinit var festivalOfferAdapter: FestivalOfferAdapter

    private lateinit var addItemDialog: BottomSheetDialog

    var lastPos: Int = -1

    /*slider*/
    lateinit var viewPager: ViewPager
    lateinit var lytPageIndicator: LinearLayout
    lateinit var sliderItems: MutableList<SliderItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puja_samgri_detail)

        initialization()
    }

    private fun initialization() {

        customHeader.txtHeaderTitle.text = resources.getString(R.string.puja_samagri)
        customHeader.imgRight1.setImageResource(R.drawable.ic_bag)

        categoryItemAdapter = CategoryItemAdapter(this@PujaSamagriDetailActivity,0)
        rvCategoryItem.layoutManager =
            LinearLayoutManager(this@PujaSamagriDetailActivity, RecyclerView.VERTICAL, false)
        rvCategoryItem.adapter = categoryItemAdapter
        categoryItemList()

        festivalOfferAdapter = FestivalOfferAdapter(this@PujaSamagriDetailActivity)
        rvFestivalOffer.layoutManager =
            LinearLayoutManager(this@PujaSamagriDetailActivity, RecyclerView.HORIZONTAL, false)
        rvFestivalOffer.adapter = festivalOfferAdapter
        festivalOfferList()

        /*Slider*/
        try {

            viewPager = findViewById(R.id.viewPager)
            lytPageIndicator = findViewById(R.id.pageIndicator)

            sliderItems = ArrayList()
            sliderItems.add(SliderItemModel(1, R.drawable.slider_one,"Get 20% Off"))
            sliderItems.add(SliderItemModel(2, R.drawable.slider_two,"Get 20% Off"))
            sliderItems.add(SliderItemModel(3, R.drawable.slider_one,"Get 20% Off"))
            sliderItems.add(SliderItemModel(3, R.drawable.slider_two,"Get 20% Off"))

            val adapter = SliderAdapter(this,  sliderItems,this)
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
    }

    override fun onClick(view: View) {
        when(view.id){
        R.id.llAddView -> {
            lastPos = Integer.parseInt(view.tag.toString())
            addItemDialog()
        }
        }
    }


    /*CategoryList*/
    private fun categoryItemList() {
        categoryItemAdapter.objList = ArrayList()

        var categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "0"
        categoryItemModel.image = R.drawable.ic_pooja_thali
        categoryItemModel.name = resources.getString(R.string.diwali_pack)
        categoryItemModel.description = resources.getString(R.string.dummy_text)
        categoryItemModel.price = resources.getString(R.string.rs_499)
        categoryItemModel.qty =
            resources.getString(R.string.add)
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "1"
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = resources.getString(R.string.diwali_pack)
        categoryItemModel.description = resources.getString(R.string.dummy_text)
        categoryItemModel.price = resources.getString(R.string.rs_499)
        categoryItemModel.qty =
            "3"
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "2"
        categoryItemModel.image = R.drawable.ic_pooja_thali
        categoryItemModel.name = resources.getString(R.string.diwali_pack)
        categoryItemModel.description = resources.getString(R.string.dummy_text)
        categoryItemModel.price = resources.getString(R.string.rs_499)
        categoryItemModel.qty =
            resources.getString(R.string.add)
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "3"
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = resources.getString(R.string.diwali_pack)
        categoryItemModel.description = resources.getString(R.string.dummy_text)
        categoryItemModel.price = resources.getString(R.string.rs_499)
        categoryItemModel.qty =
            "2"
        categoryItemAdapter.objList.add(categoryItemModel)


        categoryItemAdapter.addData(categoryItemAdapter.objList)
    }

    /*FestivalOfferList*/
    private fun festivalOfferList() {
        festivalOfferAdapter.objList = ArrayList()

        var categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "0"
        categoryItemModel.image = R.drawable.slider_one
        festivalOfferAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "1"
        categoryItemModel.image = R.drawable.slider_one
        festivalOfferAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "2"
        categoryItemModel.image = R.drawable.slider_one
        festivalOfferAdapter.objList.add(categoryItemModel)

        festivalOfferAdapter.addData(festivalOfferAdapter.objList)
    }

    /*Dialog Add Item*/
    private fun addItemDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_checkout, null)
        addItemDialog = BottomSheetDialog(this)
        addItemDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        addItemDialog.setContentView(view)
        addItemDialog.setCancelable(true)

        val rvCategoryCheck =  addItemDialog.findViewById<RecyclerView>(R.id.rvCategoryCheck)
        val txtTitle =  addItemDialog.findViewById<AppCompatTextView>(R.id.txtTitle)

        txtTitle?.text = resources.getString(R.string.diwali_pack_details)

        categoryItemAdapter = CategoryItemAdapter(this@PujaSamagriDetailActivity,2)
        rvCategoryCheck?.layoutManager =
            LinearLayoutManager(this@PujaSamagriDetailActivity, RecyclerView.VERTICAL, false)
        rvCategoryCheck?.adapter = categoryItemAdapter
        addItemList()

        addItemDialog.findViewById<AppCompatTextView>(R.id.txtCustomisePack)!!
            .setOnClickListener {
                startActivity(Intent(this@PujaSamagriDetailActivity,CategoryProcessActivity::class.java))
                addItemDialog.dismiss()
            }

        addItemDialog.findViewById<AppCompatImageView>(R.id.btnClose)!!
            .setOnClickListener {
                addItemDialog.dismiss()
            }


        addItemDialog.show()
    }


    /*Add Item List*/
    private fun addItemList() {
        categoryItemAdapter.objList = ArrayList()

        var categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "0"
        categoryItemModel.image = R.drawable.ic_flower
        categoryItemModel.name = "Flowers"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "1"
        categoryItemModel.image = R.drawable.ic_puja_pack_1
        categoryItemModel.name = "Kanku, Chandan"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "2"
        categoryItemModel.image = R.drawable.ic_flower_pack
        categoryItemModel.name = "Dhupbatti"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemModel = CategoryItemModel()
        categoryItemModel.id = "3"
        categoryItemModel.image = R.drawable.ic_puja_pack
        categoryItemModel.name = "Pooja chattai"
        categoryItemModel.description = resources.getString(R.string.dummy_text_one)
        categoryItemAdapter.objList.add(categoryItemModel)

        categoryItemAdapter.addData(categoryItemAdapter.objList)
    }

    /*SLIDER*/

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
}
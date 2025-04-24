package com.qor7.mpo.fragment

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.qor7.mpo.CategoryItemActivity
import com.qor7.mpo.ExploreProductActivity
import com.qor7.mpo.PujaSamagriDetailActivity
import com.qor7.mpo.R
import com.qor7.mpo.adapter.*
import com.qor7.mpo.model.CategoryModel
import com.qor7.mpo.model.FestivalListModel
import com.qor7.mpo.util.DataUtil
import com.rentthething.SliderItemModel
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(), View.OnClickListener {

    lateinit var rootView: View

    lateinit var viewPager: ViewPager
    lateinit var lytPageIndicator: LinearLayout
    lateinit var sliderItems: MutableList<SliderItemModel>

    private lateinit var cateAdapter: CateAdapter
    private lateinit var topOffersAdapter: TopOffersAdapter
    private lateinit var offersOfTheDayAdapter: OffersOfTheDayAdapter

    private lateinit var festivalListAdapter: FestivalListAdapter

    private lateinit var locationSpinner: CustomSpinnerAdapter

    private var lastPos: Int = -1

    private lateinit var dialog: Dialog

    private lateinit var spLocation: AppCompatSpinner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for activity!! fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false)


        initialization()


        return rootView
    }

    private fun initialization() {


        cateAdapter = CateAdapter(requireActivity(),this)
        rootView.listCategory.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        rootView.listCategory.adapter = cateAdapter
        data()

        topOffersAdapter = TopOffersAdapter(requireActivity())
        rootView.listTopOffers.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        rootView.listTopOffers.adapter = topOffersAdapter
        data1()

        offersOfTheDayAdapter = OffersOfTheDayAdapter(requireActivity())
        rootView.listOffersOfTheDay.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL,false)
        rootView.listOffersOfTheDay.adapter = offersOfTheDayAdapter
        offersOfTheDay()


        /*Slider*/
        try {
            viewPager = rootView.findViewById(R.id.viewPager)
            lytPageIndicator = rootView.findViewById(R.id.pageIndicator)

            sliderItems = ArrayList()
            sliderItems.add(SliderItemModel(1, R.drawable.slider_one,"Get 20% Off"))
            sliderItems.add(SliderItemModel(2, R.drawable.slider_two,"Get 20% Off"))
            sliderItems.add(SliderItemModel(3, R.drawable.slider_one,"Get 20% Off"))
            sliderItems.add(SliderItemModel(3, R.drawable.slider_two,"Get 20% Off"))

            val adapter = SliderAdapter(requireActivity(), sliderItems, this)
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
        when (view.id) {
            R.id.imgSlider -> {
                lastPos = Integer.parseInt(view.tag.toString())
                locationDialog()
            }
            R.id.imgCat -> {
                lastPos = Integer.parseInt(view.tag.toString())

                when (lastPos) {
                    0 -> {
                        pujaSamagriDialog()}
                    1 -> {
                        startActivity(Intent(requireActivity(), CategoryItemActivity::class.java))}
                    2 -> {
                        pujaFlowersDialog()
                    }
                }

            }
            R.id.llFestivalView -> {
                dialog.dismiss()
                lastPos = Integer.parseInt(view.tag.toString())
                startActivity(Intent(requireActivity(),PujaSamagriDetailActivity::class.java))
            }
        }
    }

    private fun locationDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_location, null)
        dialog = Dialog(requireActivity())
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.setCancelable(true)

        spLocation = dialog.findViewById(R.id.spLocation) as AppCompatSpinner

        val txtCityNotList = dialog.findViewById(R.id.txtCityNotList) as AppCompatTextView
        val txtEnterLocation = dialog.findViewById(R.id.txtEnterLocation) as AppCompatTextView
        val txtCityAdd = dialog.findViewById(R.id.txtCityAdd) as AppCompatTextView
        val edtCity = dialog.findViewById(R.id.edtCity) as AppCompatEditText
        val rlSelectCity = dialog.findViewById(R.id.rlSelectCity) as RelativeLayout

        /*SPINNER*/
        locationSpinner = CustomSpinnerAdapter(requireActivity(), 0, 0)
        DataUtil.locationCity(requireActivity(), locationSpinner)
        spLocation.adapter = locationSpinner
        spLocation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                view.setBackgroundColor(Color.TRANSPARENT)

                view.findViewById<AppCompatTextView>(R.id.txtName).setTextColor(
                    if (pos == 0) ContextCompat.getColor(
                        activity!!,
                        R.color.colorDarkGray
                    ) else ContextCompat.getColor(activity!!, R.color.colorBlack)
                )
                view.findViewById<AppCompatTextView>(R.id.txtName).textSize = 14f
            }

            override fun onNothingSelected(parent: AdapterView<out Adapter>?) {
            }
        }

        dialog.findViewById<AppCompatImageView>(R.id.imgClose)!!
            .setOnClickListener {
                dialog.dismiss()
            }

        dialog.findViewById<AppCompatTextView>(R.id.txtCityNotList)!!
            .setOnClickListener {
                txtCityNotList.visibility = View.GONE
                rlSelectCity.visibility = View.GONE
                txtEnterLocation.visibility = View.GONE
                txtCityAdd.visibility = View.VISIBLE
                edtCity.visibility = View.VISIBLE
            }

        dialog.findViewById<AppCompatTextView>(R.id.btnSubmit)!!
            .setOnClickListener {
                dialog.dismiss()
                startActivity(Intent(requireActivity(), ExploreProductActivity::class.java))
            }


        dialog.show()
    }

    private fun pujaSamagriDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_puja_samagri, null)
        dialog = Dialog(requireActivity())
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.setCancelable(true)

        val txtPujaItem = dialog.findViewById<AppCompatTextView>(R.id.txtPujaItem)

        txtPujaItem.text = resources.getText(R.string.puja_samagri_for)


        dialog.findViewById<AppCompatImageView>(R.id.imgClose)!!
            .setOnClickListener {
                dialog.dismiss()
            }

        dialog.findViewById<LinearLayout>(R.id.llFestivalView)!!
            .setOnClickListener {
                dialog.dismiss()
                festivalDialog()
            }

        dialog.findViewById<LinearLayout>(R.id.llOccasionsView)!!
            .setOnClickListener {
                dialog.dismiss()
                occasionsDialog()
            }


        dialog.show()
    }

    private fun festivalDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_festival_list, null)
        dialog = Dialog(requireActivity())
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.setCancelable(true)

        val txtName = dialog.findViewById<AppCompatTextView>(R.id.txtName)
        val festivalList = dialog.findViewById<RecyclerView>(R.id.festivalList)

        txtName.text = resources.getString(R.string.select_occasions)

        festivalListAdapter = FestivalListAdapter(requireActivity(),this)
        festivalList.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        festivalList.adapter = festivalListAdapter
        festivalList()

        dialog.findViewById<AppCompatImageView>(R.id.imgClose)!!
            .setOnClickListener {
                dialog.dismiss()
            }

        /*dialog.findViewById<LinearLayout>(R.id.llFestivalView)!!
            .setOnClickListener {
                dialog.dismiss()
                lastPos = Integer.parseInt(view.tag.toString())
                startActivity(Intent(requireActivity(),CategoryItemActivity::class.java))
            }*/

        dialog.show()
    }

    private fun occasionsDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_festival_list, null)
        dialog = Dialog(requireActivity())
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.setCancelable(true)

        val txtName = dialog.findViewById<AppCompatTextView>(R.id.txtName)
        val festivalList = dialog.findViewById<RecyclerView>(R.id.festivalList)

        txtName.text = resources.getString(R.string.select_occasions)

        festivalListAdapter = FestivalListAdapter(requireActivity(),this)
        festivalList.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        festivalList.adapter = festivalListAdapter
        occasionsList()

        dialog.findViewById<AppCompatImageView>(R.id.imgClose)!!
            .setOnClickListener {
                dialog.dismiss()
            }

        dialog.show()
    }

    private fun pujaFlowersDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_puja_samagri, null)
        dialog = Dialog(requireActivity())
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        dialog.setCancelable(true)

        val txtPujaItem = dialog.findViewById<AppCompatTextView>(R.id.txtPujaItem)

        txtPujaItem.text = resources.getText(R.string.puja_flowers_for)

        dialog.findViewById<AppCompatImageView>(R.id.imgClose)!!
            .setOnClickListener {
                dialog.dismiss()
            }

        dialog.findViewById<LinearLayout>(R.id.llFestivalView)!!
            .setOnClickListener {
                dialog.dismiss()
                festivalDialog()
            }

        dialog.findViewById<LinearLayout>(R.id.llOccasionsView)!!
            .setOnClickListener {
                dialog.dismiss()
                occasionsDialog()
            }


        dialog.show()
    }


    fun activeDeActivePageIndicator() {
        for (i in 0 until lytPageIndicator.childCount) {
            (lytPageIndicator.getChildAt(i) as ImageView).setImageResource(if (viewPager.currentItem == i) R.drawable.ic_blue_dot else R.drawable.ic_gray_dot)
        }

    }

    private fun setPagerIndicator() {
        lytPageIndicator.removeAllViews()
        for (i in sliderItems.indices) {
            val imgView = ImageView(requireActivity())
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

    private fun festivalList() {

        var festivalListModel = FestivalListModel()
        festivalListModel.festival = "Diwali"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Makarshankanti"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Holi"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Mahashivratri"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Dhanteras"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListAdapter.addData(festivalListAdapter.objList)
    }

    private fun occasionsList() {

        var festivalListModel = FestivalListModel()
        festivalListModel.festival = "Gruh pravesh"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Shrimant"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Vivah"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Office puja"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListModel = FestivalListModel()
        festivalListModel.festival = "Satyanarayan Katha"
        festivalListAdapter.objList.add(festivalListModel)

        festivalListAdapter.addData(festivalListAdapter.objList)
    }

    private fun data() {

        var objList = CategoryModel()
        objList.categoryName = "Puja samagri"
        objList.img = R.drawable.ic_puja_pack
        cateAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.categoryName = "Monthly puja kit"
        objList.img = R.drawable.ic_dhanteras
        cateAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.categoryName = "Puja flowers"
        objList.img = R.drawable.ic_flower
        cateAdapter.objList.add(objList)

        cateAdapter.addData(cateAdapter.objList)
    }

    private fun data1() {

        var objList = CategoryModel()
        objList.categoryName = "Dhup + Flower + Vachak katha kit"
        objList.price = "₹499"
        objList.img = R.drawable.ic_puja_pack_1
        topOffersAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.categoryName = "Dhanteras Puja All Set"
        objList.price = "₹599"
        objList.img = R.drawable.ic_pooja_book
        topOffersAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.categoryName = "Dhup + Flower + Vachak katha kit"
        objList.price = "₹499"
        objList.img = R.drawable.ic_puja_pack_1
        topOffersAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.categoryName = "Dhanteras Puja All Set"
        objList.price = "₹599"
        objList.img = R.drawable.ic_pooja_book
        topOffersAdapter.objList.add(objList)

        topOffersAdapter.addData(topOffersAdapter.objList)
    }

    private fun offersOfTheDay() {

        var objList = CategoryModel()
        objList.img = R.drawable.ic_flower_offer
        offersOfTheDayAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.img = R.drawable.ic_flower_pack
        offersOfTheDayAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.img = R.drawable.ic_flower_offer
        offersOfTheDayAdapter.objList.add(objList)

        objList = CategoryModel()
        objList.img = R.drawable.ic_flower_pack
        offersOfTheDayAdapter.objList.add(objList)

        offersOfTheDayAdapter.addData(offersOfTheDayAdapter.objList)
    }


}
package com.qor7.mpo.util

import android.content.Context
import com.qor7.mpo.adapter.CustomSpinnerAdapter
import com.qor7.mpo.model.SpinnerModel


object DataUtil {
    fun locationCity(
        context: Context,
        addressAdapter: CustomSpinnerAdapter
    ) {
        var spinnerModel = SpinnerModel()
        spinnerModel.id = "0"
        spinnerModel.city = "Select city"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "1"
        spinnerModel.city = "Navasari"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "2"
        spinnerModel.city = "Surat"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "3"
        spinnerModel.city = "Vadodara"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "3"
        spinnerModel.city = "Ahmedabad"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "3"
        spinnerModel.city = "valasad"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "3"
        spinnerModel.city = "Amareli"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "3"
        spinnerModel.city = "Bharuch"
        addressAdapter.objList.add(spinnerModel)

        spinnerModel = SpinnerModel()
        spinnerModel.id = "3"
        spinnerModel.city = "Rajkot"
        addressAdapter.objList.add(spinnerModel)

    }

}
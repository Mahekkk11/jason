package com.qor7.mpo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class SpinnerModel: Serializable {


    @Expose
    @SerializedName("id")
    var id: String = ""

    @Expose
    @SerializedName("city")
    var city: String = ""

}

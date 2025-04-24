package com.qor7.mpo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CategoryItemModel : Serializable{

    @Expose
    @SerializedName("id")
    var id : String = ""

    @Expose
    @SerializedName("image")
    var image : Int = 0

    @Expose
    @SerializedName("name")
    var name : String = ""

    @Expose
    @SerializedName("description")
    var description : String = ""

    @Expose
    @SerializedName("price")
    var price : String = ""

    @Expose
    @SerializedName("qty")
    var qty : String = ""

    @Expose
    @SerializedName("totalAmount")
    var totalAmount : String = ""


}
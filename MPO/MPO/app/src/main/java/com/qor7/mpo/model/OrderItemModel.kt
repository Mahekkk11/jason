package com.qor7.mpo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class OrderItemModel : Serializable{

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
    @SerializedName("code")
    var code : String = ""

    @Expose
    @SerializedName("created_at")
    var createdAt : String = ""

    @Expose
    @SerializedName("status")
    var status : String = ""

    @Expose
    @SerializedName("price")
    var price : String = ""



}
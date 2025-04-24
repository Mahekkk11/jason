package com.rentthething

class SliderItemModel {

    var imageId: Int = 0
        internal set
    var imageDrawable: Int = 0
        internal set
    var title: String = ""
        internal set

    constructor(id: Int, drawable: Int, title:String) {
        this.imageId = id
        this.imageDrawable = drawable
        this.title = title
    }
}

package com.jg.whatsappclone

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.jg.whatsappclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var mainBinding : ActivityMainBinding

private lateinit var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainBinding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        var productData = ArrayList<ProductData>()

        var productData1 = ArrayList<ProductData>()
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData1.add(ProductData(R.drawable.notifications,"MCA","JG University","60000"))
        productData.addAll(productData1)

        productAdapter = ProductAdapter(productData)

        mainBinding.rvProductList.layoutManager = LinearLayoutManager(this)
        mainBinding.rvProductList.adapter = productAdapter

    }
}
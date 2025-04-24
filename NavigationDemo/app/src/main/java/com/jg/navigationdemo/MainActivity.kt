package com.jg.navigationdemo

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.animation.AnimationUtils
import com.jg.navigationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

   private lateinit var mainBinding: ActivityMainBinding

    private lateinit var nmap : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
//
//        var fragmentManager = supportFragmentManager
//        var transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.fl,HomeFragment())
//        transaction.commit()

//        mainBinding.btnHome.setOnClickListener {
//            var fragmentManager = supportFragmentManager
//            var transaction = fragmentManager.beginTransaction()
//            transaction.replace(R.id.fl,HomeFragment())
//            mainBinding.txtHeader.text = "Home"
//            transaction.commit()
//
//        }
//
//        mainBinding.btnSearch.setOnClickListener {
//            var fragmentManager = supportFragmentManager
//            var transaction = fragmentManager.beginTransaction()
//            transaction.replace(R.id.fl,SearchFragment())
//            mainBinding.txtHeader.text = "Search"
//            transaction.commit()
//        }
//
//        mainBinding.btnProfile.setOnClickListener {
//            var fragmentManager = supportFragmentManager
//            var transaction = fragmentManager.beginTransaction()
//            transaction.replace(R.id.fl,SearchFragment())
//            mainBinding.txtHeader.text = "Profile"
//            transaction.commit()
//
//        }

        var mapfragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapfragment.getMapAsync(this)

    }


    override fun onMapReady(p0: GoogleMap) {
        nmap = p0

        var jgUni = LatLng(23.0461,72.5288)
        nmap.addMarker(MarkerOptions().position(jgUni).title("Hello"))
        nmap.moveCamera(CameraUpdateFactory.newLatLngZoom(jgUni,22f))
        nmap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        nmap.uiSettings.isZoomControlsEnabled = true

    }


}
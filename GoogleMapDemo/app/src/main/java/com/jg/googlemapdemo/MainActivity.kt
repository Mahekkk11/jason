package com.jg.googlemapdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var fragment = supportFragmentManager
            .findFragmentById(R.id.fmMapView) as SupportMapFragment
        fragment.getMapAsync(this)

    }

    override fun onMapReady(p0: GoogleMap) {

        mapView = p0

        var place = LatLng(23.0917, 72.5975)
        mapView.addMarker(MarkerOptions().position(place).title("Ahmedabad"))
        mapView.mapType = GoogleMap.MAP_TYPE_SATELLITE
        mapView.moveCamera(CameraUpdateFactory.newLatLng(place))
        mapView.uiSettings.isZoomControlsEnabled = true
    }
}
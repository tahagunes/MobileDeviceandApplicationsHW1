package com.google.codelabs.buildyourfirstmap

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.MarkerOptions
import com.google.codelabs.buildyourfirstmap.place.Place
import com.google.codelabs.buildyourfirstmap.place.PlacesReader
import kotlinx.android.synthetic.main.marker_info_contents.*

class MainActivity : AppCompatActivity() {

    private val bicycleIcon: BitmapDescriptor by lazy {
        val color = ContextCompat.getColor(this, android.R.color.holo_red_dark)
        BitmapHelper.vectorToBitmap(this, R.drawable.bus24png, color)
        //BitmapHelper.vectorToBitmap(this, R.drawable.ic_directions_bike_black_24dp, color)
    }
    private val places: List<Place> by lazy {
        PlacesReader(this).read()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapFragment = supportFragmentManager.findFragmentById(
            R.id.map_fragment
        ) as? SupportMapFragment
        mapFragment?.getMapAsync { googleMap ->
            addMarkers(googleMap)
            googleMap.setInfoWindowAdapter(MarkerInfoWindowAdapter(this))

        }

    }


    private fun addMarkers(googleMap: GoogleMap) {

        places.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .position(place.latLng)
                    .icon(bicycleIcon)
            )
            // Set place as the tag on the marker object so it can be referenced within
            //MarkerInfoWindowAdapter
            marker?.tag = place

        }

        anketgec(googleMap)
    }

    fun anketgec(googleMap: GoogleMap) {
        googleMap.setOnInfoWindowClickListener{marker -> val abc = Intent(this, Page1::class.java)
            startActivity(abc)
            true}
        /*googleMap.setOnMarkerClickListener { marker ->
            val abc = Intent(this, Page1::class.java)
            startActivity(abc)
            true
        }*/
    }
}



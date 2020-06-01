package com.example.androidjetpack.ExampleLifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpack.R
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity(){
    private val locationViewModel:LocationViewModel by lazy {
        ViewModelProvider(this).get(LocationViewModel::class.java)
    }

    private lateinit var locationListener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        setupLocationListener()
        bind()
    }

    private fun setupLocationListener(){
        locationListener = LocationListener(lifecycle){currentLocation ->
            location.text = currentLocation
            Log.d("aaa","Current message: $currentLocation")
        }
    }

    private fun bind(){
        locationViewModel.checkUserStatus().observe(this, Observer {isUserSingedIn ->
            if(isUserSingedIn){
                locationListener.enable()
            }
        })
    }
}
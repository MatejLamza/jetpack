package com.example.androidjetpack.ExampleLifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {
    fun checkUserStatus() = MutableLiveData<Boolean>().apply {
        value = true
    }
}
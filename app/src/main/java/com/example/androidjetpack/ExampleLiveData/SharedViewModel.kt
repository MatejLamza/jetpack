package com.example.androidjetpack.ExampleLiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _currentMessage = MutableLiveData<String>()
    val currentMessage: LiveData<String> = _currentMessage

    init {
        _currentMessage.value = "Test Message"
    }

    fun setNewMessage(message:String){
        _currentMessage.value = message
    }

}
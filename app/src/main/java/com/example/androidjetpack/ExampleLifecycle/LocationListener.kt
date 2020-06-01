package com.example.androidjetpack.ExampleLifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocationListener(
    val lifecycle: Lifecycle,
    private val callback: (String) -> Unit
) : LifecycleObserver{

    companion object{
        const val CONNECTED = "Connected"
        const val DISCONNECTED = "Disconnected"
    }

    private var enabled = false
    var status = ""

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){
        if(enabled){
            status = CONNECTED
            callback.invoke("Somewhere in Zagreb")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy(){
        callback.invoke("Destroying...")
        lifecycle.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop(){
        callback.invoke("Stopping")
        if(enabled){
            status = DISCONNECTED
        }
    }

    fun enable(){
        enabled = true
        if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)){
            start()
        }

    }

}
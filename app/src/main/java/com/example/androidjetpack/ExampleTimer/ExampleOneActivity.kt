package com.example.androidjetpack.ExampleTimer

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpack.R
import kotlinx.android.synthetic.main.activity_example_one.*

class ExampleOneActivity : AppCompatActivity() {

    private val exampleOneViewModel: ExampleOneViewModel by lazy {
        ViewModelProvider(this).get(ExampleOneViewModel::class.java)
    }

    //private ExampleOneViewModel viewmodel = ViewModelProvider(this).get(ExampleOneViewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_one)

        if (exampleOneViewModel.time == null) {
            val currentTime = SystemClock.elapsedRealtime()
            exampleOneViewModel.time = currentTime
            timer.base = currentTime
        } else {
            timer.base = exampleOneViewModel.time!!
        }

        timer.start()
    }
}
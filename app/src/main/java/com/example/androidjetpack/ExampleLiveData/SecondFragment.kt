package com.example.androidjetpack.ExampleLiveData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpack.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    private val sharedViewModel:SharedViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    private fun bind(){
        sharedViewModel.currentMessage.observe(viewLifecycleOwner, Observer { sharedMessage->
            recivedMessage.text = sharedMessage
        })
    }
}
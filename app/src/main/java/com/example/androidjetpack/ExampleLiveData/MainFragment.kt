package com.example.androidjetpack.ExampleLiveData

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidjetpack.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private val mainViewModel: SharedViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
    }

    private var currentMessage = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()

        nextActivity.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }
        newMessageButton.setOnClickListener {
            displayDialog()
        }
    }

    private fun bind() {
        mainViewModel.currentMessage.observe(viewLifecycleOwner, Observer { newMessage ->
            label.text = newMessage
        })
    }

    private fun displayDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Message")

        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK") { _, _ ->
            currentMessage = input.text.toString()
            mainViewModel.setNewMessage(currentMessage)
        }

        builder.show()
    }
}
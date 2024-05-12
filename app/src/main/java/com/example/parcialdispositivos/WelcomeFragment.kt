package com.example.parcialdispositivos

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    var score=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botoncito=view.findViewById<Button>(R.id.invocar)
        val imagen=view.findViewById<ImageView>(R.id.teemoimagen)
        imagen.setImageResource(R.drawable.teemo)
        botoncito.setOnClickListener{
            val datos= bundleOf("score" to score)
            view.findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment,datos)
        }

    }

}
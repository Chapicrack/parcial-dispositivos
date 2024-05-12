package com.example.parcialdispositivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController

class respuesta4 : Fragment(R.layout.fragment_respuesta4) {
    var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var respuesta=""
        arguments.let { bundle ->
            score=bundle?.getInt("score").toString().toInt()
            respuesta=bundle?.getString("correcta").toString()
        }
        val recipiente=view.findViewById<TextView>(R.id.textView49)
        if(respuesta=="okey"){
            recipiente.text="acertastes"
        }
        else{
            recipiente.text="fallastes"
        }
        val botoncito=view.findViewById<Button>(R.id.button46)
        botoncito.setOnClickListener{
            navegar(score,view)
        }

    }
    private fun navegar(score: Int, view: View) {
        val datos= bundleOf("score" to score)
        view.findNavController().navigate(R.id.action_respuesta4_to_pregunta5,datos)

    }
}
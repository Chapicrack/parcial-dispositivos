package com.example.parcialdispositivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.findNavController

class pregunta3 : Fragment(R.layout.fragment_pregunta3) {
    var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let { bundle ->
            score=bundle?.getInt("score").toString().toInt()
        }
        //otorgando valores de button a botoncitos como val
        val botoncito1=view.findViewById<Button>(R.id.button17)
        val botoncito2=view.findViewById<Button>(R.id.button16)
        val botoncito3=view.findViewById<Button>(R.id.button15)
        var correcta=""
        botoncito1.setOnClickListener{
            correcta= respuesta(1)
            navegar(correcta,view)
        }
        botoncito2.setOnClickListener{
            correcta= respuesta(2)
            navegar(correcta,view)
        }
        botoncito3.setOnClickListener{
            correcta= respuesta(3)
            navegar(correcta,view)
        }
    }
    //funcion para que se pase la informacion entre los fragmentos
    private fun navegar(correcta: String, view: View) {
        val datos= bundleOf("score" to score,"correcta" to correcta)
        view.findNavController().navigate(R.id.action_pregunta3_to_respuesta3,datos)

    }
    //comprobador de respuesta correcta
    private fun respuesta(i: Int) :String{
        if(i==3){
            return "okey"
        }
        else{
            return "no okey"
        }
    }
}
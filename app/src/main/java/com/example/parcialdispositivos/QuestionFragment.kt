package com.example.parcialdispositivos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.findNavController

class QuestionFragment : Fragment(R.layout.fragment_question) {
    var score=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let { bundle ->
            score=bundle?.getInt("score").toString().toInt()
        }
        val botoncito1=view.findViewById<Button>(R.id.button2)
        val botoncito2=view.findViewById<Button>(R.id.button3)
        val botoncito3=view.findViewById<Button>(R.id.button4)
        var correcta=""
        botoncito1.setOnClickListener{
            correcta= respuesta(1)
            val datos= bundleOf("score" to score,"correcta" to correcta)
            view.findNavController().navigate(R.id.action_questionFragment_to_answerFragment,datos)
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
    private fun navegar(correcta: String, view: View) {
        val datos= bundleOf("score" to score,"correcta" to correcta)
        view.findNavController().navigate(R.id.action_questionFragment_to_answerFragment,datos)

    }

    private fun respuesta(i: Int) :String{
        if(i==3){
            return "okey"
        }
        else{
            return "no okey"
        }

    }
}
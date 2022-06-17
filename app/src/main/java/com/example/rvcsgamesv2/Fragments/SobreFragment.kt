package com.example.senac.rvcsgames.Fragmentos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.rvcsgamesv2.R

class SobreFragment : Fragment() {

    private lateinit var buttonsite: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sobre, container, false)

        buttonsite = view.findViewById(R.id.button_site)

        buttonsite.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rvcsgames.com/")))
        }
        return view
    }
}
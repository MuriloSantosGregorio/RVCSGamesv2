package com.example.senac.rvcsgames.Fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.rvcsgamesv2.R

class XboxFragment : Fragment() {

    private lateinit var valor: TextView
    private var valordojogo: Float = 0.0f
    private lateinit var imagem: ImageView
    private lateinit var fifa22: TextView
    private lateinit var bf2042: TextView
    private lateinit var olympic: TextView
    private lateinit var farcry6: TextView
    private lateinit var residentevil7: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_xbox, container, false)
        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val jogos = arrayOf("Selecione", "Fifa 2022", "Battlefield 2042", "Olympic Games 2020", "Farcry 6", "The Last of Us Parte 1 Remake")

        valor = view.findViewById<TextView>(R.id.textview_valor)
        imagem = view.findViewById<ImageView>(R.id.imagem_jogo)
        fifa22 = view.findViewById<TextView>(R.id.jogo_fifa)
        bf2042 = view.findViewById<TextView>(R.id.jogo_bf2042)
        olympic = view.findViewById<TextView>(R.id.jogo_olympic)
        farcry6 = view.findViewById<TextView>(R.id.jogo_farcry6)
        residentevil7 = view.findViewById<TextView>(R.id.jogo_residentevil7)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, jogos)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if (p2 == 1) {
                    valordojogo = 229.99f
                    imagem.setImageResource(R.drawable.fifa22_xbox)
                    fifa22.visibility = View.VISIBLE
                    bf2042.visibility = View.INVISIBLE
                    olympic.visibility = View.INVISIBLE
                    farcry6.visibility = View.INVISIBLE
                    residentevil7.visibility = View.INVISIBLE

                } else if (p2 == 2) {
                    valordojogo = 199.99f
                    imagem.setImageResource(R.drawable.bf2042_xbox)
                    bf2042.visibility = View.VISIBLE
                    fifa22.visibility = View.INVISIBLE
                    olympic.visibility = View.INVISIBLE
                    farcry6.visibility = View.INVISIBLE
                    residentevil7.visibility = View.INVISIBLE

                } else if (p2 == 3) {
                    valordojogo = 99.99f
                    imagem.setImageResource(R.drawable.olympicgames_xbox)
                    olympic.visibility = View.VISIBLE
                    fifa22.visibility = View.INVISIBLE
                    bf2042.visibility = View.INVISIBLE
                    farcry6.visibility = View.INVISIBLE
                    residentevil7.visibility = View.INVISIBLE

                } else if (p2 == 4) {
                    valordojogo = 169.99f
                    imagem.setImageResource(R.drawable.farcry6_xbox)
                    farcry6.visibility = View.VISIBLE
                    olympic.visibility = View.INVISIBLE
                    fifa22.visibility = View.INVISIBLE
                    bf2042.visibility = View.INVISIBLE
                    residentevil7.visibility = View.INVISIBLE

                } else if (p2 == 5) {
                    valordojogo = 109.99f
                    imagem.setImageResource(R.drawable.residentevil7_xbox)
                    residentevil7.visibility = View.VISIBLE
                    olympic.visibility = View.INVISIBLE
                    fifa22.visibility = View.INVISIBLE
                    bf2042.visibility = View.INVISIBLE
                    farcry6.visibility = View.INVISIBLE
                }

                Valor()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            private fun Valor(){
                valor.text = "R$" + valordojogo.toString()
                valor.visibility = View.VISIBLE
            }
        }
        return view
    }
}

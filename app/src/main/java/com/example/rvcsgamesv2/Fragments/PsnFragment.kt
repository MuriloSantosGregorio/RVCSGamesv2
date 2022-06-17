package com.example.rvcsgamesv2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.rvcsgamesv2.R

class PsnFragment : Fragment() {

    private lateinit var valor: TextView
    private lateinit var imagem: ImageView
    private lateinit var nba2k22: TextView
    private lateinit var cod: TextView
    private lateinit var gta: TextView
    private lateinit var ghostwire: TextView
    private lateinit var thelastofus: TextView
    private var valordojogo: Float = 0.0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_psn, container, false)
        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val jogos = arrayOf("Selecione", "NBA 2k22", "Call of Duty Modern Warfare 2", "Grand Theft Auto V", "GhostWire", "The Last of Us Parte 1 Remake")

        valor = view.findViewById<TextView>(R.id.textview_valor)
        imagem = view.findViewById<ImageView>(R.id.imagem_jogo)
        nba2k22 = view.findViewById<TextView>(R.id.jogo_nba)
        cod = view.findViewById<TextView>(R.id.jogo_cod)
        gta = view.findViewById<TextView>(R.id.jogo_gta)
        ghostwire = view.findViewById<TextView>(R.id.jogo_ghostwire)
        thelastofus = view.findViewById<TextView>(R.id.jogo_thelastofus)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, jogos)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if (p2 == 1) {
                    valordojogo = 89.99f
                    imagem.setImageResource(R.drawable.nba2k22_ps4_ps5)
                    nba2k22.visibility = View.VISIBLE
                    cod.visibility = View.INVISIBLE
                    gta.visibility = View.INVISIBLE
                    ghostwire.visibility = View.INVISIBLE
                    thelastofus.visibility = View.INVISIBLE

                } else if (p2 == 2) {
                    valordojogo = 109.99f
                    imagem.setImageResource(R.drawable.cod_ps4_ps5)
                    nba2k22.visibility = View.INVISIBLE
                    cod.visibility = View.VISIBLE
                    gta.visibility = View.INVISIBLE
                    ghostwire.visibility = View.INVISIBLE
                    thelastofus.visibility = View.INVISIBLE

                } else if (p2 == 3) {
                    valordojogo = 44.99f
                    imagem.setImageResource(R.drawable.gta_ps4)
                    gta.visibility = View.VISIBLE
                    nba2k22.visibility = View.INVISIBLE
                    cod.visibility = View.INVISIBLE
                    ghostwire.visibility = View.INVISIBLE
                    thelastofus.visibility = View.INVISIBLE

                } else if (p2 == 4) {
                    valordojogo = 89.99f
                    imagem.setImageResource(R.drawable.ghostwire_ps5)
                    ghostwire.visibility = View.VISIBLE
                    gta.visibility = View.INVISIBLE
                    nba2k22.visibility = View.INVISIBLE
                    cod.visibility = View.INVISIBLE
                    thelastofus.visibility = View.INVISIBLE

                } else if (p2 == 5) {
                    valordojogo = 109.99f
                    imagem.setImageResource(R.drawable.thelastofus_ps5)
                    thelastofus.visibility = View.VISIBLE
                    gta.visibility = View.INVISIBLE
                    nba2k22.visibility = View.INVISIBLE
                    cod.visibility = View.INVISIBLE
                    ghostwire.visibility = View.INVISIBLE
                }

                Valor()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            private fun Valor(){
                valor.text = "R$" + valordojogo.toString()
                valor.visibility = View.VISIBLE
            }
        }
        return view
    }
}

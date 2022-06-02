package com.example.rvcsgamesv2.carrinho

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rvcsgamesv2.Model.Jogo
import com.example.rvcsgamesv2.R
import com.example.rvcsgamesv2.databinding.ActivityMainBinding
import com.example.rvcsgamesv2.databinding.FragmentCarrinhoBinding
import com.example.rvcsgamesv2.databinding.ItemCarrinhoBinding
import com.google.firebase.database.DataSnapshot

class CarrinhoFragment : Fragment() {

    lateinit var binding: FragmentCarrinhoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarrinhoBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_carrinho, container, false)

        atualizarTela()
    }

    fun atualizarTela(listaJogos: List<Jogo>){
        binding.container.removeAllViews()

        listaJogos.forEach{
            val itemBinding = ItemCarrinhoBinding.inflate(layoutInflater)

            itemBinding.nomeJogo.text = it.nome
            itemBinding.precoJogo.text = it.preco.toString()


            binding.container.addView(itemBinding.root)
        }
    }
}
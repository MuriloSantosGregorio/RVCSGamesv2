package com.example.rvcsgamesv2.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rvcsgamesv2.Model.Jogo
import com.example.rvcsgamesv2.R
import com.example.rvcsgamesv2.databinding.FragmentCarrinhoBinding
import com.example.rvcsgamesv2.databinding.ItemCarrinhoBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CarrinhoFragment : Fragment() {

    lateinit var binding: FragmentCarrinhoBinding
    var database: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    private fun tratarLogin() {
        if (FirebaseAuth.getInstance().currentUser == null) {
            val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                0
            )
        } else {
            configurarFirebase()
        }
    }

    fun configurarFirebase() {
        FirebaseAuth.getInstance().currentUser?.let {
            database = FirebaseDatabase.getInstance().reference.child(it.uid)

            val itemListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    tratarDadosJogos(dataSnapshot)
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.w("MainActivity", "onCancelled", databaseError.toException())

                    Toast.makeText( this@CarrinhoFragment, "Erro ao acessar o servidor",
                        Toast.LENGTH_LONG);
                }
            }

            database?.child("jogosComprar")?.addValueEventListener(itemListener)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Toast.makeText(context, "Autenticado", Toast.LENGTH_LONG).show()
            configurarFirebase()
        } else {

        }
    }

    private fun tratarDadosJogos(dataSnapshot: DataSnapshot) {
        val itemList = arrayListOf<Jogo>()

        dataSnapshot.children.forEach {
            val prod = it.getValue(Jogo::class.java)
            prod?.let {
                itemList.add(it);
            }
        }
        atualizarTela(itemList)
    }

    fun atualizarTela(list: List<Jogo>) {
        binding.container.removeAllViews()

        list.forEach {
            val item_carrinho = ItemCarrinhoBinding.inflate(layoutInflater)

            item_carrinho.nomeJogo.text = it.nome
            item_carrinho.precoJogo.text = it.preco.toString()
            item_carrinho.descjogo.text = it.descricao

            val id = it.id as String;

            //Trata o clique no botão "excluir"
            item_carrinho.excluir.setOnClickListener {
                //Obtem o item da base de dados usando o id
                val itemReference = database?.child("produtos")?.child(id)
                //Remove o item
                itemReference?.removeValue()
            }

            binding.container.addView(item_carrinho.root)
        }
    }
}
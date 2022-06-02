package com.example.rvcsgamesv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.rvcsgamesv2.databinding.ActivityMainBinding
import com.example.rvcsgamesv2.inicio.InicioFragment
import com.example.rvcsgamesv2.jogos.Ps4CFragment
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tratarLogin()

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout , R.string.abrir_menu, R.string.fechar_menu)
        binding.drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

       binding.nv.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_inicio -> {
                    val frag = InicioFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
                R.id.nav_jogos -> {
                    val frag = Ps4CFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
            }

            var fechaDrawer = binding.drawerLayout
            fechaDrawer.closeDrawers();

            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        toggle.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    fun tratarLogin() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            Toast.makeText(this, "Logado", Toast.LENGTH_SHORT).show()
        } else {
            val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())

            val i = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build()

            startActivityForResult(i,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode ==1 && resultCode == RESULT_OK) {
            Toast.makeText(this, "Autenticado", Toast.LENGTH_LONG).show()
        } else {
            finishAffinity()
        }
    }
}
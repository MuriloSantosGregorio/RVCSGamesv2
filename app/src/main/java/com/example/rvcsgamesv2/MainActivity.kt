package com.example.rvcsgamesv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.rvcsgamesv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout , R.string.abrir_menu, R.string.fechar_menu)

        binding.drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        binding.nv.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.games -> {
                    val frag = GamesGeneralFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        toggle.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

}
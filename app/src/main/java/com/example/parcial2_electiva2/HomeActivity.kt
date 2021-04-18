package com.example.parcial2_electiva2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        modificarButton.setOnClickListener {
            modifyFragment()
        }

        imagenButton.setOnClickListener {
            imagenesFragment()
        }
    }

    private fun modifyFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, modificarFragment(), null)
        transaction.commit()
    }

    private fun imagenesFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, imagenFragment(), null)
        transaction.commit()
    }
}
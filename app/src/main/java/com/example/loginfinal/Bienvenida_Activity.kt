package com.example.loginfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Bienvenida_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida_)

        val btnFinalizar = findViewById<Button>(R.id.btnSalir)


        btnFinalizar.setOnClickListener{
            Toast.makeText(this, "Saliendo de la aplicación", Toast.LENGTH_SHORT).show()
            finish()
        }

        getAndShowName()

        var botonVolver = findViewById<Button>(R.id.btnVolver)
        botonVolver.setOnClickListener{onBackPressed()}


    }

// en el evento el boton  capturo al intent anterior con la misma clave
    fun getAndShowName(){
            val bundle = intent.extras

            var tvMensaje = findViewById<TextView>(R.id.tvMensajeActivity2)

            val a = "su calve es "+bundle?.getString("PASS") //trae la clave de la actividad principal
            tvMensaje.text="Bienvenido ${bundle?.getString("US")} " //trae el usuario de la actividad principal

            Toast.makeText(this,a,Toast.LENGTH_SHORT).show()
      }
    }

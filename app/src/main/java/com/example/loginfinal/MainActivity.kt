package com.example.loginfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaro los componenetes y los conecto con la vista.
        var tvUsuario = findViewById<TextView>(R.id.tvUsuario)
        var edtUsuario = findViewById<EditText>(R.id.edtUsuario)
        var tvClave = findViewById<TextView>(R.id.tvClave)
        var edtClave = findViewById<EditText>(R.id.edtClave)
        var btnIngresar = findViewById<Button>(R.id.btnIngresar)

        // Capturo el envento de escucha (Onclic)
        btnIngresar.setOnClickListener{

            ingresar(edtUsuario,edtClave)
        }

    }
    //Fin

    fun ingresar(edtUsuario: EditText, edtClave: EditText ){

        // tomo el valor del EdiTex Usuario
        var conviertoEdtUsuario = edtUsuario.text.toString()
        var conviertoEdClave = edtClave.text.toString()

        // Creo el objeto de la clase usuario
        var usuario = Usuarios(conviertoEdtUsuario,conviertoEdClave)
        // Defino valores para luego compararlos,

        usuario.nombreUsuario="Admin"
        usuario.clave ="1234"
        // Verifico a través de un TOAST que el dato se obtiene correctamente y lo imprimo
        Toast.makeText(this, "${usuario.nombreUsuario}", Toast.LENGTH_SHORT).show()

        // si la caja esta vacio sale un mensaje
        if(conviertoEdtUsuario.isEmpty()) {
            Toast.makeText(this, "Ingrese un nombre de usuario", Toast.LENGTH_SHORT).show()
        }
        // Validación de nombre de usuario
        if(conviertoEdtUsuario.equals(usuario.nombreUsuario)){

            Toast.makeText(this, "Nombre usuario correcto!", Toast.LENGTH_SHORT).show()
            if(conviertoEdClave.equals(usuario.clave)) {
                // Programar acceso a nuevo pantalla con Indent
                Toast.makeText(this,"Acceso correcto, Ingresando al sistema...",Toast.LENGTH_SHORT).show()

                // ****** 2 PANTALLA *******     Creo un objeto intent       // nombre de la activity a la que voy

                val intent = Intent(this, Bienvenida_Activity:: class.java)

                 // Esta parte es para recuperar datos de la misma Activity, le paso una clave

                // Envío datos a la 2° Activity
                val b: Bundle = Bundle() //Creo un obj
                b.putString("US",usuario.nombreUsuario) //llamo al método y le paso una clave + el dato a enviar
                b.putString("PASS", usuario.clave)
                intent.putExtras(b) // le paso el obj creado
                startActivity(intent) // comienzo la actividad

            }
            else
            {
                Toast.makeText(this, "Clave incorrecta, verifique y vuelva a intentarlo", Toast.LENGTH_SHORT).show()
            }
        }
        if(!conviertoEdtUsuario.equals(usuario.nombreUsuario)){
            Toast.makeText(this, "Error, nombre usuario no existe", Toast.LENGTH_SHORT).show()

        }

    }

}




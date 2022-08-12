package mx.itesm.clase1pm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // podriamos checar nulls
        // TODO: miren si funciona

        //Log.d("MAIN", "debug")
        //Log.i("MAIN", "info")
        //Log.w("MAIN", "warn")
        //Log.e("MAIN", "error")
        Log.wtf("MAIN", "ONCREATE")

        // como acceder a un widget (elemento de GUI)
        // notas de kotlin
        // 2 opciones para definir el tipo de variable
        // 1- explícito
        // 2- implicito / inferido

        // explícito
        // var textito : TextView = findViewById<TextView>(R.id.textView)

        // implícito - dejar que el compilador lo infiera
        // var textito = findViewById<TextView>(R.id.textView)

        // por su "modificabilidad" las variables pueden ser
        // - mutables
        // - inmutables

        // mutable - la variable es reasignable
        // var textito = findViewById<TextView>(R.id.textView)

        // prueba de mutabilidad
        // textito = findViewById<TextView>(R.id.textView)

        // inmutable - la variable NO es reasignable
        val textito = findViewById<TextView>(R.id.textView)
        editText = findViewById(R.id.editTextTextPersonName)
        val boton1 = findViewById<Button>(R.id.button)

        textito.text = "DESDE CÓDIGO"
        Log.wtf("MAIN", editText.text.toString())
        boton1.text = "TAMBIEN."

        boton1.setOnClickListener {

            (it as Button).text = "PRESIONADO"
            Toast.makeText(this, "BOTON PRESIONADO (listener)", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.wtf("MAIN", "ONSTART")
    }

    override fun onStop() {
        super.onStop()

        Log.wtf("MAIN", "ONSTOP")
    }

    fun mostrarMensaje(view: View?) {

        // TIPOS EN KOTLIN
        // 2 GRANDES CATEGORÍAS
        // 1 - non-nullable
        // 2 - nullable

        (view as Button).text = "PRESIONADO"

        Toast.makeText(this, "BOTON PRESIONADO", Toast.LENGTH_SHORT).show()
    }

    fun cambiarActividad(view: View?){

        // el cambio de actividad se solicita a SO
        // nosotros NO creamos la nueva actividad, ni su objeto

        // llenar un "formulario" que se llama intent
        // se puede solicitar una actividad de 2 maneras:
        // - con el tipo específico
        // - por la acción que queramos ejecutar

        val intent = Intent(this, SegundaActivity::class.java)

        intent.putExtra("nombre", editText.text.toString())
        intent.putExtra("calificacion", 100)

        startActivity(intent)


    }
}
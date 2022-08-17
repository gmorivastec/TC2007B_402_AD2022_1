package mx.itesm.clase1pm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SegundaActivity : AppCompatActivity() {

    private lateinit var entrada : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        // prueba de datos enviados
        Toast.makeText(this, intent.getStringExtra("nombre"), Toast.LENGTH_SHORT).show()
        entrada = findViewById(R.id.actividad2Nombre)
    }

    fun regresar(view: View?){

        // vamos a usar un intent para almacenar datos
        // OJO - aquí usamos el constructor vacío
        val intent = Intent()

        // ponemos valores en intent
        intent.putExtra("resultadoNombre", entrada.text.toString())
        intent.putExtra("resultadoCalificacion", 80)

        // muy importante si estamos escuchando el resultado
        setResult(Activity.RESULT_OK, intent)

        // con esto se termina ejecución de esta actividad
        finish()

        // IMPORTANTE: NO hay que crear la actividad anterior de vuelta
    }
}
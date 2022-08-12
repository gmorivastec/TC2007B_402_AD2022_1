package mx.itesm.clase1pm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        // prueba de datos enviados
        Toast.makeText(this, intent.getStringExtra("nombre"), Toast.LENGTH_SHORT).show()
    }

    fun regresar(view: View?){
        // con esto se termina ejecución de esta actividad
        finish()

        // IMPORTANTE: NO hay que crear la actividad anterior de vuelta
    }
}
package mx.itesm.clase1pm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DBActivity : AppCompatActivity() {

    private lateinit var id : TextView
    private lateinit var nombre : EditText
    private lateinit var edad : EditText
    private lateinit var db : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        id = findViewById(R.id.actividadDbId)
        nombre = findViewById(R.id.actividadDbNombre)
        edad = findViewById(R.id.actividadDbEdad)

        db = DBHelper(this)
    }

    fun guardarDato(view : View?){

        db.save(nombre.text.toString(), edad.text.toString().toInt())
        // tip para la vida:
        // informen al usuario que ALGO está pasando
        Toast.makeText(this, "guardando registro", Toast.LENGTH_SHORT).show()
    }

    fun borrarDato(view : View?) {

        val rows = db.delete(nombre.text.toString())
        Toast.makeText(this, "$rows registros eliminados", Toast.LENGTH_SHORT).show()
    }

    fun buscarDato(view : View?){

        val idEncontrado = db.find(nombre.text.toString())
        id.text = idEncontrado.toString()
        //Toast.makeText(this, "id encontrado: $idEncontrado", Toast.LENGTH_SHORT).show()
    }
}
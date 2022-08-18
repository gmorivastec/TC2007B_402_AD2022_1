package mx.itesm.clase1pm

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


// 1ero - vamos a almacenar en una db local
// utilizando SQLite

class DBHelper(context : Context?) : SQLiteOpenHelper(context, DB_FILE, null, 1) {

    companion object {

        // un companion object tiene valores que puedes usar en una clase

        // lo voy a usar para definir constantes
        private const val DB_FILE = "Alumnos.db"
        private const val TABLE = "alumnos"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_AGE = "age"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        // este método se llama "automáticamente"
        // cuando la base de datos no existe y es necesario crearla

        // aquí se crean todas las tablas, relaciones, etc que forman nuestra db
        val query = "CREATE TABLE $TABLE(" +
                "$COLUMN_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_AGE INTEGER)"

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, anterior: Int, actual: Int) {

        // se manda llamar con cambio de versión de db
        // lo más correcto es lidiar con migración de datos

        // lo más más básico - destruye lo que hay pon lo nuevo
        // prepared statements
        val query = "DROP TABLE IF EXISTS ?"
        val args = arrayOf(TABLE)

        db?.execSQL(query, args)
        onCreate(db)
    }

    // guardar registro
    fun save(nombre : String, edad : Int){

        val valores = ContentValues()
        valores.put(COLUMN_NAME, nombre)
        valores.put(COLUMN_AGE, edad)

        // 2 maneras de obtener referencia a la db
        // - readableDatabase
        // - writableDatabase
        writableDatabase.insert(TABLE, null, valores)
    }

    // borrar registro
    fun delete(nombre : String) : Int {

        // clausula - condición que reduce el alcance del dominio
        // (crea un subdominio)
        val clause = "$COLUMN_NAME = ?"
        val args = arrayOf(nombre)

        return writableDatabase.delete(TABLE, clause, args)
    }

    // buscar registro
    fun find(nombre : String) : Int {

        val clause= "$COLUMN_NAME = ?"
        val args = arrayOf(nombre)
        val cursor = readableDatabase.query(TABLE, null, clause, args, null, null, null)

        var result = -1

        if(cursor.moveToFirst()){

            result = cursor.getInt(0)
        }

        // como recorrer estructura
        while(cursor.moveToNext()){
            // hacer algo con cada registro
        }

        return result
    }
}
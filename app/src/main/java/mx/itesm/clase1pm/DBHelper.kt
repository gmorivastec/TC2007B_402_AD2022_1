package mx.itesm.clase1pm

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

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}
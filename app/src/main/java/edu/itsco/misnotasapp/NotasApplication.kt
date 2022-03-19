package edu.itsco.misnotasapp

import android.app.Application
import edu.itsco.misnotasapp.bd.NotaRepositorio
import edu.itsco.misnotasapp.bd.NotasRoomDatabase

class NotasApplication: Application() {
    val database by lazy { NotasRoomDatabase.getInstance(this) }
    val repositorio by lazy { NotaRepositorio(database.notasDao())}
}
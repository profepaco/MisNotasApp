package edu.itsco.misnotasapp.bd

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class NotaRepositorio(private val notasDao: NotasDao) {

    val allNotas: Flow<List<Nota>> = notasDao.getAllNotas()

    @SuppressWarnings("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(nota: Nota){
        notasDao.insert(nota)
    }
}
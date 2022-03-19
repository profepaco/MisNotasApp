package edu.itsco.misnotasapp.bd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDao {
    @Query("SELECT * FROM notas_table ORDER BY id ASC")
    fun getAllNotas(): Flow<List<Nota>>

    @Insert
    suspend fun insert(nota: Nota)
}
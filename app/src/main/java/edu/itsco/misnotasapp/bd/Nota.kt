package edu.itsco.misnotasapp.bd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notas_table")
data class Nota(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "titulo") val titulo:String,
    @ColumnInfo(name = "contenido") val contenido: String
)
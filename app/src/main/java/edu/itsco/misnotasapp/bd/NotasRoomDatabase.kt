package edu.itsco.misnotasapp.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Nota::class), version = 1, exportSchema = false)
abstract class NotasRoomDatabase: RoomDatabase() {

    abstract fun notasDao(): NotasDao

    companion object{

        @Volatile
        private var INSTANCE: NotasRoomDatabase? = null

        fun getInstance(context: Context):NotasRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                context.applicationContext,
                NotasRoomDatabase::class.java,
                "notas_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
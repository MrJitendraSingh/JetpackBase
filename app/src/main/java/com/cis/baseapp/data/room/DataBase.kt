package com.cis.baseapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun getDao(): Dao
}
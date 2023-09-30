package com.cis.baseapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(todo: Todo)

    @Query("SELECT * FROM todoTable ")
    fun getData(): Flow<List<Todo>>
}
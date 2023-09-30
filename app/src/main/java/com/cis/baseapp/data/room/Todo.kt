package com.cis.baseapp.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")
data class Todo (
    var title: String,
    var description: String
        ){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
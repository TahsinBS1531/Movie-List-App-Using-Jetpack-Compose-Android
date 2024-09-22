package com.example.movielistapp.Home_Screen.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie_card")
data class MovieCardEntity(
    @PrimaryKey
    var id:Int,
    var title:String,
    var poster:String
)
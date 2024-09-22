package com.example.movielistapp.movie_details

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie_details")
data class MovieDetailsEntity(
    @PrimaryKey
    var id:Int,
    var title: String,
    var overview: String,
    var vote:Double,
    var release_date: String,
    var genres:List<String>
)

data class MovieGenre(
    val id: Int,
    val name: String
)
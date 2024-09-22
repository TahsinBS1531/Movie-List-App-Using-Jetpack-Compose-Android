package com.example.movielistapp.Home_Screen.model

import com.example.movielistapp.Home_Screen.data.MovieCardEntity
import com.example.movielistapp.Home_Screen.model.Result

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
){
    fun toTopRatedMovieEntity():MovieCardEntity{
        return MovieCardEntity(
            id = id,
            poster = poster_path,
            title = original_title
        )
    }

    fun toMovieDto():movieDto{
        return movieDto(
            id = id,
            poster = poster_path,
            title = title
        )
    }
}

data class movieDto(var id:Int,var poster:String,var title:String)

package com.example.movielistapp.movie_details

import com.example.movielistapp.movie_details.model.MovieDetailsDto
import com.example.movielistapp.movie_details.model.MovieDetailsResponse


sealed class MovieDetailsEvent{
    data class ShowDetails(var id:Int):MovieDetailsEvent()
}

data class MovieDetailsState(
    var movieData:MovieDetailsDto? = null
)
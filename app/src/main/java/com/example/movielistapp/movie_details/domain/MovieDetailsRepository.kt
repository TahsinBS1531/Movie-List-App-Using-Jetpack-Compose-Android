package com.example.movielistapp.movie_details.domain

import com.example.movielistapp.core.repository.mapSuccess
import com.example.movielistapp.movie_details.model.MovieDetailsResponse
import javax.inject.Inject

class MovieDetailsRepository @Inject constructor(private val api:MovieDetailsApiInterface) {

    suspend fun getMovieDetailsById(id:Int):MovieDetailsResponse{
        return api.getMovieDetails(movieId = id).mapSuccess {
            it
        }
    }
}
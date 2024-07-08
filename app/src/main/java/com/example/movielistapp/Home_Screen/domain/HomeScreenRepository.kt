package com.example.movielistapp.Home_Screen.domain

import com.example.movielistapp.Home_Screen.model2.PopularMoviesResponse
import com.example.movielistapp.Home_Screen.model2.TopRatedMoviesResponse2
import com.example.movielistapp.core.repository.BaseRepository
import com.example.movielistapp.core.repository.mapSuccess
import javax.inject.Inject

class HomeScreenRepository @Inject constructor (private val api:HomeScreenApiInterface):
    BaseRepository {

    suspend fun getTopRatedMovies():TopRatedMoviesResponse2{
        return api.getTopRatedMovies().mapSuccess {
            it
        }
    }

    suspend fun getPopularMovies():PopularMoviesResponse{
        return api.getPopularMovies().mapSuccess {
            it
        }
    }
}
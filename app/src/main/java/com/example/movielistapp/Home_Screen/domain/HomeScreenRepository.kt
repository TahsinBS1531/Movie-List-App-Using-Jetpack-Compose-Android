package com.example.movielistapp.Home_Screen.domain

import com.example.movielistapp.Home_Screen.model.TopRatedResponse
import javax.inject.Inject

class HomeScreenRepository @Inject constructor (private val api:HomeScreenApiInterface):BaseRepository {

    suspend fun getTopRatedMovies():TopRatedResponse{
        return api.getTopRatedMovies("imdb231.p.rapidapi.com","324b5b8ec3mshcdbbd1cd5b0de70p159039jsnb2cadae3ed8d").mapSuccess {
            it
        }
    }
}
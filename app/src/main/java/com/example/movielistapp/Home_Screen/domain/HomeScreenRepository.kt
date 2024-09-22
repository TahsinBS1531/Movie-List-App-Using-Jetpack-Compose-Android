package com.example.movielistapp.Home_Screen.domain

import com.example.movielistapp.Home_Screen.HomeScreenViewState
import com.example.movielistapp.Home_Screen.data.MovieCardEntity
import com.example.movielistapp.Home_Screen.model.PopularMoviesResponse
import com.example.movielistapp.Home_Screen.model.Result
import com.example.movielistapp.Home_Screen.model.TopRatedMoviesResponse2
import com.example.movielistapp.core.db.MovieDao
import com.example.movielistapp.core.repository.BaseRepository
import com.example.movielistapp.core.repository.mapSuccess
import javax.inject.Inject

class HomeScreenRepository @Inject constructor (private val api:HomeScreenApiInterface,private val movieDao:MovieDao):
    BaseRepository {

    suspend fun getTopRatedMovies():List<Result>{
        return api.getTopRatedMovies().mapSuccess {
            it
        }
    }

    suspend fun appSync(){

        val topRatedMovieCard = getTopRatedMovies()
        topRatedMovieCard.forEach {
            movieDao.saveMovieCard(it.toTopRatedMovieEntity())
        }

    }


    suspend fun getPopularMovies():List<Result>{
        return api.getPopularMovies().mapSuccess {
            it
        }
    }

}
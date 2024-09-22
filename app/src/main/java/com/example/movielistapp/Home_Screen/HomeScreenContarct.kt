package com.example.movielistapp.Home_Screen

import com.example.movielistapp.Home_Screen.data.MovieCardEntity
import com.example.movielistapp.Home_Screen.model.PopularMoviesResponse
import com.example.movielistapp.Home_Screen.model.Result
import com.example.movielistapp.Home_Screen.model.TopRatedMoviesResponse2
import com.example.movielistapp.Home_Screen.model.movieDto

sealed class HomeScreenEvent {
    object LoadTopRatedMovies : HomeScreenEvent()
    object LoadtPopularMovies:HomeScreenEvent()

    object SaveOfflineData:HomeScreenEvent()
}


data class HomeScreenViewState(
    val topRatedModel: List<movieDto>? = null,
    val popularMovieModel:List<movieDto>? = null,
    var topRatedMoviesCached:List<MovieCardEntity>?=null,
    val isSuccess: Boolean = false,
    var isLoading:Boolean = false
)
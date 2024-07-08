package com.example.movielistapp.Home_Screen

import com.example.movielistapp.Home_Screen.model2.PopularMoviesResponse
import com.example.movielistapp.Home_Screen.model2.TopRatedMoviesResponse2

sealed class HomeScreenEvent {
    object LoadTopRatedMovies : HomeScreenEvent()
    object LoadtPopularMovies:HomeScreenEvent()
}


data class HomeScreenViewState(
    val topRatedModel: TopRatedMoviesResponse2? = null,
    val popularMovieModel:PopularMoviesResponse? = null,
    val isSuccess: Boolean = false
)
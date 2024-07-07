package com.example.movielistapp.Home_Screen

import com.example.movielistapp.Home_Screen.model.TopRatedResponse

sealed class HomeScreenEvent {
    object LoadTopRatedMovies : HomeScreenEvent()
}


data class HomeScreenViewState(
    val topRatedModel: TopRatedResponse? = null,
    val isSuccess: Boolean = false
)